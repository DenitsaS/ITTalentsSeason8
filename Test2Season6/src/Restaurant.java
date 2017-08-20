import java.util.HashMap;
import java.util.Map;

public class Restaurant {

	private String name;
	private String adress;
	private double capital;
	private Menu menu;
	private Waiter[] waiters;
	Map<String, Integer> countOfFoodAndDrink = new HashMap<String, Integer>();

	Restaurant(String name, String adress, double capital, Menu menu, Waiter[] waiters) {
		this.name = name;
		this.adress = adress;
		this.capital = capital;
		this.menu = menu;
		this.waiters = waiters;
		countOfFoodAndDrink.put(Alcohol.class.getName(), 20);
		countOfFoodAndDrink.put(NonAlcohol.class.getName(), 20);
		countOfFoodAndDrink.put(Salad.class.getName(), 10);
		countOfFoodAndDrink.put(MainDish.class.getName(), 10);
		countOfFoodAndDrink.put(Dessert.class.getName(), 10);
	}

	public boolean hasEnoughFoodAndDrink(String name) {
		return countOfFoodAndDrink.get(name) > 0;
	}

	public boolean takeOrder(String name) {
		if (!hasEnoughFoodAndDrink(name)) {
			return false;
		}

		int newCount = countOfFoodAndDrink.get(name) - 1;
		countOfFoodAndDrink.put(name, newCount);
		return true;
	}

	public String getName() {
		return name;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public Menu getMenu() {
		return menu;
	}

	public Waiter[] getWaiters() {
		return waiters;
	}

}