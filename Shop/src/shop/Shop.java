package shop;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import products.Product;

public class Shop implements IShop{
	private String name;
	private String address;
	private double money;
	private Set<Product> products;
	
	public Shop(String name, String address, double money) {
		super();

		if(name != null && !name.equals("")){
			this.name = name;
		} else {
			this.name = "bezime";
		}
		if(money > 0){
			this.money = money;
		} else {
			this.money = 3;
		}

		if(address != null && !address.equals("")){
			this.address = address;
		} else {
			this.address = "bezaddress";
		}
		this.products = new HashSet<Product>();
	}
	
	@Override
	public void addProduct(Product product) {
		if(!products.contains(product)){
			products.add(product);
		} else {
			for (Product _product : products) {
				if(_product.equals(product)){
					_product.setAvailability(_product.getAvailability() + product.getAvailability());
				}
			}
		}
	}
	

	public Product getProductByName(String name) {
		for (Product product : products) {
			if(product.getName().equals(name)){
				return product;
			}
		} 
		return null;
	}

	public double getMoney() {
		return money;
	}
	
	public void addMoney(int money){
		if(money > 0){
			this.money += money;
		} 
	}
	
	@Override
	public String toString() {
		String s = "";
		for (Product product : products) {
			s=s.concat(product.getName() + " " + product.getAvailability() + "\n");
		}
		return s;
	}
	
}
