package agency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.sun.glass.ui.View;

import clients.Buyer;
import clients.Seller;
import estates.Estate;

public class Agent extends ContactInfo implements Comparable<Agent> {
	private Set<Seller> sellers;
	private Set<Buyer> buyers;
	private List<View> views;
	private double money;
	private Agency agency;
	public Agent(String name, Agency agency) {
		super(name);
		sellers = new HashSet<Seller>();
		buyers = new HashSet<Buyer>();
		views = new ArrayList<View>();
		this.agency = agency;
		this.money = new Random().nextDouble() * 80;
	}
	
	public void addSeller(Seller seller){
		sellers.add(seller);
	}
	
	public void addBuyer(Buyer buyer){
		buyers.add(buyer);
	}
	
	public void getComission(double money){
		this.money += money;
	}

	public Estate askForEstate(double money) {
		Estate e = agency.getSuitableEstate(money);
		if(e == null){
			System.out.println("We don't have estate for you, you can live on the street");
		}
		return e;
	}

	public void payToAgency(double d) {
		//1.5 because the seller gives 3% of the price too
		agency.addMoney(d * 1.5);
		this.money += d * 0.5;
		
	}

	public void sellEstate(Estate e, Buyer b) {
		for(Seller seller : sellers){
			if(seller.getEstate().equals(e))
				this.agency.sellEstate(e, b,  seller, this);
			}
	}

	@Override
	public int compareTo(Agent agent) {
		if(this.money > agent.money){
			return 1;
		}
		if(this.money < agent.money){
			return -1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return name + " has "+ money + "money\n";
	}
}
