import java.util.HashSet;

public abstract class PersonWithLawyers extends Citizen{
	HashSet<Lawyer> lawyers;
	PersonWithLawyers(String name, HashSet<Lawyer> lawyers) {
		super(name);
		if(lawyers != null){
			this.lawyers = lawyers;
		}
	}

}
