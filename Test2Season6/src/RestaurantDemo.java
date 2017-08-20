import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class RestaurantDemo {
	public static void main(String[] args) {
		Waiter[] waiters = new Waiter[5];
		waiters[0] = new Waiter("Deni");
		waiters[1] = new Waiter("Stefi");
		waiters[2] = new Waiter("Ivan");
		waiters[3] = new Waiter("Galq");
		waiters[4] = new Waiter("Maria");
		
		List<FoodAndDrink> foodAndDrinks = new ArrayList<FoodAndDrink>();
		foodAndDrinks.add(new MainDish(500));
		foodAndDrinks.add(new Alcohol());
		foodAndDrinks.add(new NonAlcohol());
		foodAndDrinks.add(new Salad(500));
		foodAndDrinks.add(new Dessert(300));
		Menu menu = new Menu(foodAndDrinks);
		Restaurant priPesho = new Restaurant("Pri pesho", "Studentski grad", 1000, menu, waiters);

		Client[] clients = new Client[15];
		for (int i = 0; i < clients.length; i++) {
			Random r = new Random();
			int chance = r.nextInt(10);
			if(chance < 2){
				clients[i] = new Vegan(priPesho.getWaiters(),priPesho);
			} else if(chance < 5){
				clients[i] = new Student(priPesho.getWaiters(),priPesho);
			} else {
				clients[i] = new Mutra(priPesho.getWaiters(),priPesho);
			}
		}
		
		startDay(menu, clients, priPesho);
	}
	
	public static void startDay(Menu menu, Client[] clients, Restaurant restaurant){
		for (int i = 0; i < clients.length; i++) {

			Random r = new Random();
			int index = r.nextInt(5);
			
			FoodAndDrink product = menu.getMenuProducts().get(index);
			//we choose a random product, then check if the client can consume it, and if not we choose another one until the order is made
			if(!clients[i].canConsume(product) ||
					!restaurant.hasEnoughFoodAndDrink(product.getClass().getName()) ||
					clients[i].money * 0.9 < product.price){
				i--;
				continue;
			}
			
			List<FoodAndDrink> foodAndDrinks = new ArrayList<FoodAndDrink>();
			foodAndDrinks.add(menu.getMenuProducts().get(index));
			clients[i].makeOrder(foodAndDrinks);
			System.out.println(clients[i].getBill());
		}
		
		for (int i = 0; i < clients.length; i++) {
			System.out.println(clients[i].getBill());
			clients[i].payForBill();
		}
		
		System.out.println("All money of restaurant " + restaurant.getCapital());
		
		Set<Waiter> waitersWithTips = new TreeSet<Waiter>();
		for (int i = 0; i < restaurant.getWaiters().length; i++) {
			waitersWithTips.add(restaurant.getWaiters()[i]);
		}		
		
		for (Waiter waiter : waitersWithTips) {
			
			System.out.println(waiter.getName() + "'s tip " + waiter.getTipp());
		}
		
		for (Map.Entry<String, Integer> foodAndDrink : restaurant.countOfFoodAndDrink.entrySet()) {
			System.out.println(foodAndDrink.getKey() + " " + foodAndDrink.getValue());
		}
	}
}
