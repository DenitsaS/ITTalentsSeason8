import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

public class Demo {
	public static void main(String[] args) {
		List<Judge> judges = new ArrayList<Judge>();
		judges.add(new Judge("Valentin", 0, 8)); 
		judges.add(new Judge("Miroslav", 0, 8)); 
		judges.add(new Judge("Angel", 0, 8)); 
		
		List<PublicProsecuter> publicProsecuters = new ArrayList<PublicProsecuter>();

		publicProsecuters.add(new PublicProsecuter("Georgi", 0, 8)); 
		publicProsecuters.add(new PublicProsecuter("Ivan", 0, 8)); 
		
		Set<JuryMan> juryMen = new HashSet<JuryMan>();

		juryMen.add(new JuryMan("Pesho", 0, 8)); 
		juryMen.add(new JuryMan("Milen", 0, 8)); 
		juryMen.add(new JuryMan("Nako", 0, 8)); 
		juryMen.add(new JuryMan("Nasko", 0, 8)); 
		juryMen.add(new JuryMan("Stefcho", 0, 8)); 
		juryMen.add(new JuryMan("Nikolaj", 0, 8)); 
		juryMen.add(new JuryMan("Ralica", 0, 8)); 
		juryMen.add(new JuryMan("Mihaela", 0, 8)); 
		juryMen.add(new JuryMan("Martin", 0, 8)); 
//
//		List<LegalEntity> lawyers = new ArrayList<LegalEntity>();
//		lawyers.add(new Lawyer("Pesho", 0, 8)); 
//		lawyers.add(new Lawyer("Pesho", 0, 8)); 
//		lawyers.add(new Lawyer("Pesho", 0, 8)); 
//		lawyers.add(new Lawyer("Pesho", 0, 8)); 
//		lawyers.add(new Lawyer("Pesho", 0, 8)); 
		
		
		HashSet<Lawyer> lawyers = new HashSet<Lawyer>();
		lawyers.add(new Lawyer("Sasho", 0, 8));
		lawyers.add(new Lawyer("Sando", 0, 8));
		lawyers.add(new Lawyer("Konstantina", 0, 8));
		lawyers.add(new Lawyer("Iva", 0, 8));
		lawyers.add(new Lawyer("Kami", 0, 8));
		
		List<Prosecutor> procecutors = new ArrayList<Prosecutor>();
		procecutors.add(new Prosecutor("Deni", lawyers));
		
		procecutors.add(new Prosecutor("Beni",lawyers));
		procecutors.add(new Prosecutor("Olq", lawyers));
		procecutors.add(new Prosecutor("Mira", lawyers));
		procecutors.add(new Prosecutor("Slavka", lawyers));
		
		List<Defendant> defendants = new ArrayList<Defendant>();

		defendants.add(new Defendant("Kalina",lawyers));
		defendants.add(new Defendant("Malina",lawyers));
		defendants.add(new Defendant("Vesi",lawyers));
		defendants.add(new Defendant("Hristina",lawyers));
		defendants.add(new Defendant("Dimityr",lawyers));
		
		Set<Witness> witnesses = new HashSet<Witness>();

		
		witnesses.add(new Witness("Stanimir"));
		witnesses.add(new Witness("Stanislaw"));
		witnesses.add(new Witness("Ivo"));
		witnesses.add(new Witness("Kiro"));
		witnesses.add(new Witness("Toshko"));
		witnesses.add(new Witness("Maq"));
		witnesses.add(new Witness("Poli"));
		witnesses.add(new Witness("Tihomir"));
		witnesses.add(new Witness("Daniel"));
		witnesses.add(new Witness("Vqra"));
		
		List<Case> cases = new ArrayList<Case>();
		List<LegalEntity> legalEntities = new ArrayList<>();
		legalEntities.addAll(lawyers);
		for (JuryMan juryMan : juryMen) {
			legalEntities.add(juryMan);
		}
		
		legalEntities.addAll(publicProsecuters);
		

		for (Lawyer lawyer: lawyers) {
			legalEntities.add(lawyer);
		}
		
		
		Court court = new Court("Veliko Tyrnovo", "Undola", cases, legalEntities);
		cases.add(new CivilCase(judges.get(new Random().nextInt(judges.size())), juryMen,
				procecutors.get(new Random().nextInt(procecutors.size())),
				defendants.get(new Random().nextInt(defendants.size())), witnesses));

		cases.add(new CivilCase(judges.get(new Random().nextInt(judges.size())), juryMen,
				procecutors.get(new Random().nextInt(procecutors.size())),
				defendants.get(new Random().nextInt(defendants.size())), witnesses));

		cases.add(new CivilCase(judges.get(new Random().nextInt(judges.size())), juryMen,
				procecutors.get(new Random().nextInt(procecutors.size())),
				defendants.get(new Random().nextInt(defendants.size())), witnesses));

		cases.add(new CriminalCase(judges.get(new Random().nextInt(judges.size())), juryMen,
				publicProsecuters.get(new Random().nextInt(publicProsecuters.size())),
				defendants.get(new Random().nextInt(defendants.size())), witnesses));

		cases.add(new CriminalCase(judges.get(new Random().nextInt(judges.size())), juryMen,
				publicProsecuters.get(new Random().nextInt(publicProsecuters.size())),
				defendants.get(new Random().nextInt(defendants.size())), witnesses));

		cases.add(new CriminalCase(judges.get(new Random().nextInt(judges.size())), juryMen,
				publicProsecuters.get(new Random().nextInt(publicProsecuters.size())),
				defendants.get(new Random().nextInt(defendants.size())), witnesses));
		
		court.printInfo();

		for (Case case1 : cases) {
			case1.conduct();
			System.out.println(case1.chronology.toString());
		}
		court.printInfo();
	}
}
