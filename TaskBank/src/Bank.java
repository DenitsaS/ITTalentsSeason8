import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank extends ContactInfo implements IBank {

	private static final double PERCENT_OF_SALARY_TO_LEND_CREDIT = 0.5;

	private static final double PERCENT_OF_RESERVE = 0.9;
	
	List<BankProduct> products = new ArrayList<BankProduct>();
	private double rezerv;
	
	public Bank(String name, String adress, long balance, List<BankProduct> bankProducts) {
		super(name, adress, balance);
		if (bankProducts != null && bankProducts.size() > 0 ) {
			this.products = bankProducts;
		}
		
	}

	public double getRezerv() {
		return rezerv;
	}

	@Override
	public Deposit openDeposit(double money)  {
		this.increaseBalance(money);
		this.rezerv += PERCENT_OF_RESERVE*money;
		BankProduct product;
		do {
			product = this.products.get(new Random().nextInt(products.size()));
		}
		while(!(product instanceof Deposit));
		
		Deposit result = new Deposit(product.getName(), 
				product.getPeriod(), product.getInterest());
		
		result.setBalance(money);
		
		return result;
	}

	@Override
	public Credit lendCredit(IClient client, int money, int period) {
		double sumOfVnoski = 0;
		
			List<Credit> credits = ((Client)client).getCredits();
			for (Credit c : credits) {
				sumOfVnoski += c.getVnoska();
			}
			
			if ( sumOfVnoski < ((Client)client).getSalary()*PERCENT_OF_SALARY_TO_LEND_CREDIT) {
				this.decreaseBalance(money);
				this.setRezerv(PERCENT_OF_RESERVE*money);
			}
			
			BankProduct product;
			do {
				product = this.products.get(new Random().nextInt(products.size()));
			}
			while(!(product instanceof Credit));
			
			Credit result = new Credit(product.getName(), 
					product.getPeriod(), product.getInterest());
			result.setBalance(money);
			result.setVnoska(money/period);
		
		return result;
	}

	public void setRezerv(double rezerv) {
		this.rezerv -= rezerv;
	}
	
	
}
