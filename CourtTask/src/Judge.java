
public class Judge extends LegalEntity {
	
	Judge(String name, int countOfCases, int yearsOfPractice) {
		super(name);
		if(yearsOfPractice < 5){
			this.yearsOfPractice = 5;
		} else {
			this.yearsOfPractice = yearsOfPractice;
		}
		this.countOfCases = countOfCases;
	}

}
