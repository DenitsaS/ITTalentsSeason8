import java.util.Set;

public class CriminalCase extends Case{
	PublicProsecuter publicProsecuter;
	CriminalCase(Judge judge, Set<JuryMan> juryMen, PublicProsecuter publicProsecuter, Defendant defendant, Set<Witness> witnesses) {
		super(judge, defendant, witnesses, juryMen);
		if(juryMen.size() == 13){
			this.juryMen = juryMen;
		}
		if(publicProsecuter != null){
			this.publicProsecuter = publicProsecuter;
		}

	}
	@Override
	void conduct() {
		super.conduct();
		
			this.publicProsecuter.countOfCases++;
			chronology.names.add(this.publicProsecuter.name);
			for(int i = 0; i < 5; i++){
				chronology.questions.add(this.publicProsecuter.name + " asked " + defendant.name + " a question");
				for(int j = 0; j < 5;j++){
					for (Witness witness : witnesses) {
						chronology.questions.add(this.publicProsecuter.name + " asked " + witness.name + " a question");
					}
				}
			}
		}
	}


