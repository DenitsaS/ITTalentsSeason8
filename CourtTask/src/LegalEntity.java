
public abstract class LegalEntity extends Person{
	protected int countOfCases;
	protected int yearsOfPractice;
	LegalEntity(String name) {
		super(name);
	}
	
	@Override
	public String toString() {
		return name + " - " + countOfCases;
	}

}
