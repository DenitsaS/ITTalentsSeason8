import java.util.List;
import java.util.Random;

public class Mutra extends Client {

	Mutra(Waiter[] waiters, Restaurant restaurant) {
		this.money = 50;
		Random r = new Random();
		this.waiter = waiters[r.nextInt(waiters.length - 1)];
		this.restaurant = restaurant;
		this.bill = 0;

	}

	@Override
	void makeOrder(List<FoodAndDrink> orders) {
		for (int i = 0; i < orders.size(); i++) {
			if(canConsume(orders.get(i))){
				restaurant.takeOrder(orders.get(i).getClass().getName());
				bill += orders.get(i).price;
			}
		}
	}

	// canConsume checks if the person can make this order
	@Override
	boolean canConsume(FoodAndDrink order) {
		double moneyForOrders = money * 0.8 - bill;
		if (!(order instanceof MainDish) && !(order instanceof Alcohol)) {
			System.out.println("You are mutra, you cannot order this!");
			return false;
		} else if (order.price > moneyForOrders) {
			System.out.println("Sorry you don't have enough money for this order");
			return false;
		}

		String food = order.getClass().getName();
		if (!restaurant.hasEnoughFoodAndDrink(food)) {
			System.out.println("Sorry, we don't have any " + food + " left.");
			return false;
		}
		return true;
	}
}
