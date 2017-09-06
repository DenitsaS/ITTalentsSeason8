package agency;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import clients.Buyer;
import clients.Seller;
import estates.Estate;
import estates.Estate.EstateKind;
import estates.EstateType;

public class Agency extends ContactInfo {
	private TreeSet<Agent> agents;
	private String address;
	private HashMap<EstateKind, HashMap<EstateType,ArrayList<Estate>>> catalog;
	private double budget;
	
	public Agency(String name,  String address) {
		super(name);
		if(isDataValid(address)){
			this.address = address;
		}
		this.agents = new TreeSet<Agent>();
		this.catalog = new HashMap<EstateKind, HashMap<EstateType,ArrayList<Estate>>>();
		this.budget = 0;
		
	}
	
	public void addAgent(Agent agent){
		agents.add(agent);
	}
	
	public Agent getRandomAgent(){
		int r = new Random().nextInt(agents.size());
		
		int i = 0;
		for (Agent agent : agents) {
			if(i == r) {
				return agent;
			}
			
			i++;
		}
		
		return null;
	}
	

	
	public Estate getRandomEstate(){		
		int randInd = new Random().nextInt(EstateKind.values().length);
		EstateKind kind = EstateKind.values()[randInd];
		
		HashMap<EstateType, ArrayList<Estate>> map = this.catalog.get(kind);
		 randInd = new Random().nextInt(map.keySet().size());
		
		ArrayList<Estate> arr = null;
		int currentMap = 0;
		for (Entry<EstateType, ArrayList<Estate>> entry : map.entrySet()) {
			if(currentMap == randInd) {
				arr = entry.getValue();
			}
			
			currentMap++;
		}
		
		if (arr.size() > 0) {
			randInd = new Random().nextInt(arr.size());
			Estate c = arr.get(randInd);
			return c;
		} else {
			return this.getRandomEstate();
		}

	}
	
	public void addEstateToCatalog(Estate e){
		EstateKind kind = e.getKind();
		EstateType type = e.getType();
		if (!this.catalog.containsKey(kind)) {
			this.catalog.put(kind, new HashMap<>());
		}
		if (!this.catalog.get(kind).containsKey(type)) {
			this.catalog.get(kind).put(type, new ArrayList<>());
		}
		this.catalog.get(kind).get(type).add(e);
	}
	
	public void addMoney(double money){
		this.budget += money;
	}
	
	public void printCatalog() {
		for (Entry<EstateKind, HashMap<EstateType, ArrayList<Estate>>> entry : this.catalog.entrySet()) {
			System.out.println(entry.getKey());

			HashMap<EstateType, ArrayList<Estate>> map = entry.getValue();

			for (Entry<EstateType, ArrayList<Estate>> entry2 : map.entrySet()) {
				System.out.println("  " + entry2.getKey());

				entry2.getValue().sort(new Comparator<Estate>() {

					@Override
					public int compare(Estate o1, Estate o2) {
						if(o1.getPrice() > o2.getPrice()){
							return 1;
						}
						
						if(o1.getPrice() < o2.getPrice()){
							return -1;
						}
						return 0;
					}
				});
				
				for (Estate e : entry2.getValue()) {
					System.out.println("    " + e);
				}
			}

		}
	}

	public Estate getSuitableEstate(double money) {
		ArrayList<Estate> arr = new ArrayList<Estate>();
		for(Entry<EstateKind, HashMap<EstateType,ArrayList<Estate>>> entry : this.catalog.entrySet()){
			for(Entry<EstateType,ArrayList<Estate>> entry2 : entry.getValue().entrySet()){
				for(Estate estate : entry2.getValue()){
					if(estate.getPrice() * 1.03 <= money){
						arr.add(estate);
					}
				}
			}
		}
		
		if(arr.size() == 0){
			return null;
		} 
		
		int r = new Random().nextInt(arr.size());
		return arr.get(r);
	}

	public void sellEstate(Estate e) {
		
	}

	public void sellEstate(Estate e, Buyer b, Seller s, Agent agent) {
		s.recieveMoney(b.payForEstate(e));
		this.budget+=s.payComision();
		this.budget += b.payComission(e);
		agent.getComission(e.getPrice() * 0.3);
		this.budget -= e.getPrice() * 0.3;
	}
	
	public void printAgents(){
		for(Agent agent : agents){
			System.out.println(agent);
		}
	}
}
