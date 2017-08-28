import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class Case {
	Chronology chronology;
	int countOfGuiltyBlamers;
	Judge judge;
	Defendant defendant;
	Set<JuryMan>  juryMen;
	Set<Witness> witnesses;
	Case(Judge judge, Defendant defendant, Set<Witness> witnesses){
		this.witnesses = witnesses;
		countOfGuiltyBlamers = 0;
		this.juryMen = new HashSet();
		if(judge != null){
			this.judge = judge;
		}
		if(defendant!= null){
			this.defendant = defendant;
		}
		chronology = new Chronology();
	}
	
	void conduct(){
		judge.countOfCases++;
		for (JuryMan juryMan : juryMen) {
			juryMan.countOfCases++;
			chronology.names.add(juryMan.name);
		}
		for (Witness witness : witnesses) {
			chronology.names.add(witness.name);
		}
		
		for (Lawyer lawyer: defendant.lawyers) {

			for (Witness witness : witnesses) {
				for(int i = 0; i < 5; i++){
					chronology.questions.add(lawyer.name + " asked " + witness.name + " a question");
				}
			}
		}
		chronology.names.add(defendant.name);
		chronology.names.add(judge.name);
		
		for (JuryMan juryMan : juryMen) {
			if(juryMan.isGulty()){
				chronology.decisions.add(juryMan.name + " found " + defendant.name + " guilty");
				countOfGuiltyBlamers++;
			} else {
				chronology.decisions.add(juryMan.name + " found " + defendant.name + " not guilty");
			}
		}
		
		

		if(countOfGuiltyBlamers > juryMen.size() / 2){
			chronology.decisions.add(judge.name + " found "+  defendant.name + " gulty! The sentence is" + (new Random().nextInt(40) + 3));
		} else {
			chronology.decisions.add(judge.name + " found "+  defendant.name + " not gulty!");
		}
	}
	

}
