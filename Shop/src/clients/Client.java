package clients;

import java.util.HashMap;
import java.util.Map;

import products.Product;
import products.ProductByCount;
import products.ProductByWeight;
import shop.Shop;

public class Client implements IClient {
	private Shop shop;
	private double money;
	private int maxCountOfProducts;
	private Map<Product, Integer> productsInCart;
	
	public Client(Shop shop, double money, int maxCountOfProducts) {
		super();
		this.shop = shop;
		this.money = money;
		this.maxCountOfProducts = maxCountOfProducts;
		productsInCart = new HashMap<Product, Integer>();
	}

	@Override
	public void addProductByWeight(String name, int weight) {
		
		Product p  = shop.getProductByName(name);
		if(p == null){
			System.out.println("nqma takyv produkt");
			return;
		}
		
		if(!(p instanceof ProductByWeight)){
			System.out.println("ne si izbral weight");
			return;
		}
		
		if(maxCountOfProducts <= 0) {
			System.out.println("ne moje da si kupuwash poweche neshta");
			return;
		}
		
		if(p.getAvailability() < weight) {
			System.out.println("Nqma tolkowa bojki ot " + name + "a samo " + p.getAvailability());
			return;
		}
		
		if(p.getPrice() * weight> this.money){
			System.out.println("nqmash pari");
			return;
		}

		p.setAvailability(p.getAvailability() - weight);
		money -= p.getPrice() * weight;
		productsInCart.put(p, weight);
		maxCountOfProducts--;
		
	}

	@Override
	public void addProductByCount(String name, int count) {

		Product p  = shop.getProductByName(name);
		if(p == null){
			System.out.println("nqma takyv produkt");
			return;
		}
		if(!(p instanceof ProductByCount)){
			System.out.println("ne si izbral count");
			return;
		}
		
		if(maxCountOfProducts <= 0) {
			System.out.println("ne moje da si  kupuwash poweche neshta");
			return;
		}
		
		if(p.getAvailability() < count) {
			System.out.println("Nqma tolkowa bojki ot " + name + " a samo " + p.getAvailability());
			return;
		}
		
		if(p.getPrice() * count > this.money){
			System.out.println("nqmash pari");
			return;
		}
		this.money-= p.getPrice() * count;
		p.setAvailability(p.getAvailability() - count);
		productsInCart.put(p, count);
		maxCountOfProducts--;
	}
		

	@Override
	public void removeProductByWeight(String name) {

		Product p  = shop.getProductByName(name);
		if(p instanceof ProductByWeight){
			int availability = productsInCart.get(p);
			this.money+= p.getPrice() * availability;
			p.setAvailability(p.getAvailability() + availability);
			productsInCart.remove(p);
			maxCountOfProducts++;
		}		
	}

	@Override
	public void removeProductByCount(String name) {

		Product p  = shop.getProductByName(name);
		if(p instanceof ProductByCount){
			int availability = productsInCart.get(p);
			this.money+= p.getPrice() * availability;
			p.setAvailability(p.getAvailability() + availability);
			productsInCart.remove(p);
			maxCountOfProducts++;
		}		
		
	}

	@Override
	public void buyProductsinCart() {
		for (Map.Entry<Product, Integer> entry : productsInCart.entrySet()) {
			shop.addMoney(entry.getKey().getPrice() * entry.getValue());
		}
	}
}
