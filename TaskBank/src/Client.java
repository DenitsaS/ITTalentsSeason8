import java.util.ArrayList;
import java.util.List;

public class Client extends ContactInfo implements IClient{
	
	private static final int MIN_SUM_FOR_DEPOSIT = 0;
	private int salary;
	public int getSalary() {
		return salary;
	}


	private List<Deposit> deposits = new ArrayList<Deposit>();
	private List<Credit> credits = new ArrayList<Credit>();
	
	public Client(String name, String adress, long balance, int salary) {
		super(name, adress, balance);
		if ( salary > 0 ) {
			this.salary = salary;
		}
	}

	
	@Override
	public void lenCredit() {
		for (int i = 0; i < credits.size(); i++) {
			this.decreaseBalance(credits.get(i).getVnoska());
		}
		
	}


	@Override
	public void openDeposit(IBank bank, double money) {
		if ( money > MIN_SUM_FOR_DEPOSIT && money <= this.getBalance()) {
			this.decreaseBalance(money);
			Deposit deposit = bank.openDeposit(money);
			this.deposits.add(deposit);
		} else {
			System.out.println("Tiq pari ne stigat za otwarqne na deposit, mahaj se ot tuka");
		}
	}


	@Override
	public void askForCredit(IBank bank, int money, int period) {
		
		Credit credit = bank.lendCredit(this, money, period);
		credits.add(credit);
	}
	
	public List<Credit> getCredits() {
		return credits;
	}


	public double getDepositMoney () {
		double money = 0;
		for (Deposit d:deposits) {
			money += d.getBalance();
		}
		return money;
	}
	
	public void printInfo() {
		System.out.println(super.toString());
		
		System.out.println("Crediti: ");
		for (Credit c : credits) {
			System.out.println(c.toString());
		}
		
		System.out.println("Deposits: ");
		for (Deposit c : deposits) {
			System.out.println(c.toString());
		}
	}
	
	

}

