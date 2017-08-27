import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

public class Demo {
	public static void main(String[] args) {
		List<Judge> judges = new ArrayList<Judge>();
		judges.add(new Judge("Pesho", 0, 8)); 
		judges.add(new Judge("Pesho", 0, 8)); 
		judges.add(new Judge("Pesho", 0, 8)); 
		
		List<PublicProsecuter> publicProsecuters = new ArrayList<PublicProsecuter>();

		publicProsecuters.add(new PublicProsecuter("Pesho", 0, 8)); 
		publicProsecuters.add(new PublicProsecuter("Pesho", 0, 8)); 
		
		Set<JuryMan> juryMen = new HashSet<JuryMan>();

		juryMen.add(new JuryMan("Pesho", 0, 8)); 
		juryMen.add(new JuryMan("Pesho", 0, 8)); 
		juryMen.add(new JuryMan("Pesho", 0, 8)); 
		juryMen.add(new JuryMan("Pesho", 0, 8)); 
		juryMen.add(new JuryMan("Pesho", 0, 8)); 
		juryMen.add(new JuryMan("Pesho", 0, 8)); 
		juryMen.add(new JuryMan("Pesho", 0, 8)); 
		juryMen.add(new JuryMan("Pesho", 0, 8)); 
		juryMen.add(new JuryMan("Pesho", 0, 8)); 
//
//		List<LegalEntity> lawyers = new ArrayList<LegalEntity>();
//		lawyers.add(new Lawyer("Pesho", 0, 8)); 
//		lawyers.add(new Lawyer("Pesho", 0, 8)); 
//		lawyers.add(new Lawyer("Pesho", 0, 8)); 
//		lawyers.add(new Lawyer("Pesho", 0, 8)); 
//		lawyers.add(new Lawyer("Pesho", 0, 8)); 
		
		
		HashSet<Lawyer> lawyers = new HashSet<Lawyer>();
		lawyers.add(new Lawyer("Pesho", 0, 8));
		lawyers.add(new Lawyer("Pesho", 0, 8));
		lawyers.add(new Lawyer("Pesho", 0, 8));
		lawyers.add(new Lawyer("Pesho", 0, 8));
		lawyers.add(new Lawyer("Pesho", 0, 8));
		
		List<Prosecutor> procecutors = new ArrayList<Prosecutor>();
		procecutors.add(new Prosecutor("Deni", lawyers));
		
		procecutors.add(new Prosecutor("Deni",lawyers));
		procecutors.add(new Prosecutor("Deni", lawyers));
		procecutors.add(new Prosecutor("Deni", lawyers));
		procecutors.add(new Prosecutor("Deni", lawyers));
		
		List<Defendant> defendants = new ArrayList<Defendant>();

		defendants.add(new Defendant("Deni",lawyers));
		defendants.add(new Defendant("Deni",lawyers));
		defendants.add(new Defendant("Deni",lawyers));
		defendants.add(new Defendant("Deni",lawyers));
		defendants.add(new Defendant("Deni",lawyers));
		
		Set<Witness> witnesses = new HashSet<Witness>();

		
		witnesses.add(new Witness("Deni"));
		witnesses.add(new Witness("Deni"));
		witnesses.add(new Witness("Deni"));
		witnesses.add(new Witness("Deni"));
		witnesses.add(new Witness("Deni"));
		witnesses.add(new Witness("Deni"));
		witnesses.add(new Witness("Deni"));
		witnesses.add(new Witness("Deni"));
		witnesses.add(new Witness("Deni"));
		witnesses.add(new Witness("Deni"));
		
		List<Case> cases = new ArrayList<Case>();
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
		
		
		
		for (Case case1 : cases) {
			case1.conduct();
			System.out.println(case1.chronology.toString());
		}
//		Set<LegalEntity> legalEntities = new HashSet();
//		legalEntities.addAll(lawyers);
//		legalEntities.addAll(procecutors);
//		Court court = new Court("Veliko Tyrnovo", "Undola", cases, );
	}
}
