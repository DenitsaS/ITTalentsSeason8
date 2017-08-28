
public abstract class ContactInfo {

	private String name;
	private String adress;
	private long balance;

	public ContactInfo(String name, String adress, long balance) {
		if (isValid(name))
			this.name = name;
		else
			this.name = "Mani go to ime ot tuka";

		if (isValid(adress))
			this.adress = adress;
		else
			this.adress = "Mani go to adres ot tuka";

		if (balance > 0)
			this.balance = balance;

	}

	private boolean isValid(String string) {
		return (string != null) && (!string.equals(""));
	}

	long getBalance() {
		return this.balance;
	}

	void decreaseBalance(double money) {
		if (money > 0 && money <= this.balance) {
			this.balance -= money;
		}
	}
	
	void increaseBalance(double money) {
		if (money > 0 ) {
			this.balance += money;
		}
	}
	
	
	public String toString() {
		return "Zdravejte az sym: " + this.name 
				+ " namiram se tuka " + this.adress 
				+ " i imam tolkova pari: " + balance;
		
	}

}
