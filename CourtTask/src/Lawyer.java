
public class Lawyer extends LegalEntity {

	Lawyer(String name, int countOfCases, int yearsOfPractice) {
		super(name);
		
		this.yearsOfPractice = yearsOfPractice;
		if(countOfCases < 10){
			this.countOfCases = 10;
		} else {
			this.countOfCases = countOfCases;
		}
	}

}
