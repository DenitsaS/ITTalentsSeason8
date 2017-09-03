package demo;

import clients.Client;
import products.ProductByCount;
import products.ProductByWeight;
import shop.Shop;

public class Demo {
	public static void main(String[] args) {
		Shop shop = new Shop("Baba Qga", "Studentski grad", 500);
		shop.addProduct(new ProductByCount("bira", 4, 8));
		shop.addProduct(new ProductByCount("sok", 6, 2));
		shop.addProduct(new ProductByCount("vodka", 3, 4));
		shop.addProduct(new ProductByCount("uiski", 5, 18));
		shop.addProduct(new ProductByCount("rom", 2, 17));

		shop.addProduct(new ProductByWeight("qbylki", 3, 20));
		shop.addProduct(new ProductByWeight("krushi", 4, 20));
		shop.addProduct(new ProductByWeight("meso", 7, 20));
		shop.addProduct(new ProductByWeight("riba", 9, 20));
		
		Client pesho = new Client(shop, 400,10);
		Client gosho = new Client(shop, 40, 5);
		System.out.println(shop);
		
		pesho.addProductByCount("bira", 5);
		pesho.addProductByCount("sok", 3);
		pesho.addProductByCount("vodka", 4);
		pesho.addProductByCount("uiski", 1);
		pesho.buyProductsinCart();
		
		gosho.addProductByWeight("qbylki", 5);
		gosho.addProductByWeight("krushi", 1);
		gosho.addProductByWeight("meso", 2);
		gosho.addProductByWeight("riba", 1);
		gosho.buyProductsinCart();
		
		System.out.println(shop);
		
		
	}
}
