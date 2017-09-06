package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import agency.Agency;
import agency.Agent;
import clients.Buyer;
import clients.Seller;
import estates.Apartment;
import estates.ConstructType;
import estates.EstateType;
import estates.House;
import estates.Parcel;

public class Demo {
	private static final int countOfBuyers = 10;
	private static final int countOfSellers = 30;
	private static final int countOfAgents = 5;

	public static void main(String[] args) {
		Agency agency = new Agency("Talanti estate", "Studentski grad");
		
		final String [] names = {"Pesho", "Gosho", "Mitko", "Dani", "Mimi"};
		
		for(int i = 0; i < countOfAgents; i++){
			agency.addAgent(new Agent(names[new Random().nextInt(names.length)], agency));
		}
		
		List<Seller> sellers = new ArrayList<Seller>();
		
		int countOfViews = 3;
		for(int i = 0; i < countOfSellers; i++){
			int rand = new Random().nextInt(countOfViews);

			EstateType e = null;
			ConstructType c = null;
			int area = 0;
			int price = 0;
			switch (rand) {
			case 0: 
				 e = EstateType.ApartmentType.values()[new Random().nextInt(EstateType.ApartmentType.values().length)];
				 c = ConstructType.values()[new Random().nextInt(ConstructType.values().length)];
				 area = new Random().nextInt(500);
				 price = new Random().nextInt(80000) + 70000;
				sellers.add(new Seller(names[new Random().nextInt(names.length)], 
						new Apartment(price, e, area, c)));
				break;
			case 1:
				 e = EstateType.HouseType.values()[new Random().nextInt(EstateType.HouseType.values().length)];
				 c = ConstructType.values()[new Random().nextInt(ConstructType.values().length)];
				 area = new Random().nextInt(500);
				 price = new Random().nextInt(30000) + 50000;
				 sellers.add(new Seller(names[new Random().nextInt(names.length)], 
						new House(price, e, area, c)));
				break;
			case 2:
				 e = EstateType.ParcelType.values()[new Random().nextInt(EstateType.HouseType.values().length)];
				 c = ConstructType.values()[new Random().nextInt(ConstructType.values().length)];
				 area = new Random().nextInt(500);
				 price = new Random().nextInt(55000) + 30000;
				 sellers.add(new Seller(names[new Random().nextInt(names.length)], 
						new Parcel(price, e, area, new Random().nextBoolean())));
			break;
			}
			sellers.get(i).registerEstate(agency.getRandomAgent());
			agency.addEstateToCatalog(sellers.get(i).getEstate());
		}
		
		List<Buyer> buyers = new ArrayList<Buyer>();
		for(int i = 0; i < countOfBuyers;i++){
			buyers.add(new Buyer(names[new Random().nextInt(names.length)], new Random().nextInt(120000)+ 30000));
			buyers.get(i).registerForEstate(agency.getRandomAgent());
			
			for(int j = 0; j < countOfViews; j++){
				buyers.get(i).askForView();
			}
			
			buyers.get(i).buyEstate();
		}
		
		agency.printCatalog();
		agency.printAgents();
		
	}

	
	
}
