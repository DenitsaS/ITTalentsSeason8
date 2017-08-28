public abstract class BankProduct {
	
	private String name;
	private int interest;
	private int period;
	private double balance;
	
	public String getName() {
		return name;
	}

	public int getInterest() {
		return interest;
	}

	public int getPeriod() {
		return period;
	}

	public double getBalance() {
		return balance;
	}

	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	
	public BankProduct(String name, int period, int interest) {
		this.name = name;
		this.period = period;
		this.interest = interest;

	}
	
	public String toString() {
		return "Bank product: " + this.name 
				+ " lihva: " + this.interest 
				+ " pari: " + this.balance 
				+ " period : " + this.period;
	}

}
