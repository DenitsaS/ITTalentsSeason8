import java.util.HashSet;

public class Prosecutor extends PersonWithLawyers {

	Prosecutor(String name,  HashSet<Lawyer> lawyers) {
		super(name, lawyers);
	}

}
