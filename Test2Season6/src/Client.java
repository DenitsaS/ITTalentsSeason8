import java.util.List;
import java.util.Random;

public abstract class Client extends Person {
	protected int money;
	protected Waiter waiter;
	protected double bill;
	protected Restaurant restaurant;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Waiter getWaiter() {
		return waiter;
	}

	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	double askForBill() {
		return this.bill;
	}

	void payForBill() {
		Random r = new Random();
		int tippChance = r.nextInt(9) + 1;
		double tippPercent = 0.01 * (r.nextInt(5) + 5);
		if (tippChance < 8) {
			waiter.setTipp(waiter.getTipp() + bill * tippPercent);
		}
		money -= bill;
		restaurant.setCapital(restaurant.getCapital() + bill);
		System.out.println("You just payed " + (bill + (bill * tippPercent)) + " leva!");
	}

	abstract void makeOrder(List<FoodAndDrink> orders);
	abstract boolean canConsume(FoodAndDrink order);

}
