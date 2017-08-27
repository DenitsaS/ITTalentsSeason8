
public class PublicProsecuter extends LegalEntity{

	PublicProsecuter(String name, int countOfCases, int yearsOfPractice) {
		super(name);
		if(yearsOfPractice < 5){
			this.yearsOfPractice = 5;
		} else {
			this.yearsOfPractice = yearsOfPractice;
		}
		this.countOfCases = countOfCases;
	}

}
