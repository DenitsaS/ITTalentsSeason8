

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DemoBank {

	private static final int CLIENTS_COUNT = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Deposit shortDeposit = new Deposit("Short Deposit", 3, 3);
		Deposit longDeposit = new Deposit("Long Deposit", 12, 5);
		
		Credit homeCredit = new Credit("Home Credit", new Random().nextInt(60) + 1, 6);
		Credit consumerCredit = new Credit("Consumer Credit", new Random().nextInt(60) + 1, 10);
	
		List<BankProduct> bankProducts = new ArrayList<BankProduct>();
		bankProducts.add(shortDeposit);
		bankProducts.add(longDeposit);
		bankProducts.add(homeCredit);
		bankProducts.add(consumerCredit);
		
		Bank bank = new Bank("BurkanBank", "Nadejda 1", 1_000_000L, bankProducts);
		
		final String[] names = {"Pesho", "Gesho", "Mina", "Ginka", "Penka", "Gancho", "Puhi"};
		
		List<Client> clients = new ArrayList<Client>();
		for (int i = 0; i< CLIENTS_COUNT; i++) {
			Client client = new Client(names[new Random().nextInt(names.length)], 
					"Nadejda", 
					new Random().nextInt(5000) + 1000,  
					new Random().nextInt(3000) + 300);
			clients.add(client);
		}
		
		for (int i = 0; i< CLIENTS_COUNT; i++) {
			Client client = clients.get(i);
			client.openDeposit(bank, 
					(((new Random().nextInt(21) + 80.0)/100.0)
							*client.getBalance()));
		}
		
		System.out.println("Balansa na bankata: " + bank.getBalance());
		
		System.out.println("Rezerva na bankata: " + bank.getRezerv());
		
	
		for (int i = 0; i< CLIENTS_COUNT; i++) {
			Client client = clients.get(i);
			client.askForCredit(bank, new Random().nextInt(3000)+100, 
					new Random().nextInt(60) + 1);
			
		}
		
		for (Client c : clients) {
			c.printInfo();
		}
		
		

		System.out.println("Balansa na bankata: " + bank.getBalance());
		
		System.out.println("Rezerva na bankata: " + bank.getRezerv());
		
	}

}
