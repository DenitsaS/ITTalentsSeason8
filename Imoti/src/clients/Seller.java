package clients;

import agency.Agent;
import estates.Estate;

public class Seller extends Client {
	
	private Estate estate;
	private Agent agent;
	private double money = 0;
	
	public Seller(String name, Estate estate) {
		super(name);
		if(estate != null){
			this.estate = estate;
		}
		agent = null;
		
	}
	
	public void registerEstate(Agent a){
		this.agent = a;
		this.agent.addSeller(this);

	}
	
	public void recieveMoney(){
		money += estate.getPrice();
	}

	public Estate getEstate() {
		return estate;
	}

	public void recieveMoney(double d) {
		this.money += d;
	}

	public double payComision() {
		this.money -= estate.getPrice() * 0.3;
		return estate.getPrice() * 0.3;
	}

}
