package clients;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import agency.Agent;
import estates.Estate;
import estates.View;

public class Buyer extends Client{
	private Agent agent;
	private double money;
	private List<View> views;
	public Buyer(String name,int money) {
		super(name);
		if(money > 0){
			this.money = money;
		}
		views = new ArrayList<View>();
	}
	
	public void registerForEstate(Agent a){
		this.agent = a;
		this.agent.addBuyer(this);
	}
	
	public void askForView(){
		Estate e = this.agent.askForEstate(money);
		if(e!= null){
			views.add(new View(e, agent, this));
		}
	}
	
	public void buyEstate(){
		Estate e = views.get(new Random().nextInt(views.size())).getEstate();
		this.agent.sellEstate(e , this);
	}
	
	public double payForEstate(Estate e){
		money -= e.getPrice();
		return e.getPrice();
	}
	
	public double payComission(Estate e){
		money -= e.getPrice() * 0.3;
		return e.getPrice() * 0.3;
	}
	public Agent getAgent() {
		return agent;
	}
}
