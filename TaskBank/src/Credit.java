
public class Credit extends BankProduct{

	public void setVnoska(int vnoska) {
		this.vnoska = vnoska;
	}

	private int vnoska;
	
	public int getVnoska() {
		return vnoska;
	}

	public Credit(String name, int period, int interest) {
		super(name, period, interest);
		vnoska = (int)this.getBalance()/period * interest/100;
		
	}
	
}
