import java.util.Set;

public class CivilCase extends Case {
	Prosecutor prosecutor;

	CivilCase(Judge judge, Set<JuryMan> juryMen, Prosecutor prosecutor, Defendant defendant, Set<Witness> witnesses) {
		super(judge, defendant, witnesses);
		if(juryMen.size() == 3){
			this.juryMen = juryMen;
		}
		if(prosecutor != null){
			this.prosecutor = prosecutor;
		}
 	}

	@Override
	void conduct() {
		super.conduct();
		for (Lawyer lawyer: prosecutor.lawyers) {
			for(int i = 0; i < 3; i++){
					chronology.questions.add(lawyer.name + " asked " + defendant.name + " a question");
				}
			for (Witness witness : witnesses) {
				for(int i =0; i < 2; i++){
				chronology.questions.add(lawyer.name + " asked " + witness.name + " a question");
				}
			}
		}
		
		chronology.names.add(((CivilCase)this).prosecutor.name);
		for(int i = 0; i < 5; i++){
			chronology.questions.add(((CivilCase)this).prosecutor.name + " asked " + defendant.name + " a question");
				for(int j = 0; j < 5;j++){
					for (Witness witness : witnesses) {
						chronology.questions.add(((CivilCase)this).prosecutor.name + " asked " + witness.name + " a question");
						}
					}
		}
		
	}

}
