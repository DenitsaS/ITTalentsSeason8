import java.util.HashSet;

public class Defendant extends PersonWithLawyers{

	Defendant(String name,  HashSet<Lawyer> lawyers) {
		super(name, lawyers);
	}

}
