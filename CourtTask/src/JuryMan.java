import java.util.Random;

public class JuryMan extends LegalEntity {

	JuryMan(String name, int countOfCases, int yearsOfPractice) {
		super(name);
		this.countOfCases = countOfCases;
		this.yearsOfPractice = yearsOfPractice;
	}
	boolean isGulty(){
		Random r = new Random();
		return  r.nextBoolean();
		
	}
}
