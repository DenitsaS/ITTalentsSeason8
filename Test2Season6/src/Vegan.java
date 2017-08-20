import java.util.List;
import java.util.Random;

public class Vegan extends Client {

	Vegan(Waiter[] waiters, Restaurant restaurant) {
		
		this.money = 30;
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

	@Override
	boolean canConsume(FoodAndDrink order) {

		double moneyForOrders = money * 0.8 - bill;
		if (!(order instanceof Salad) || (order instanceof Alcohol)) {
			System.out.println("You are a vegan, you cannot order unhealthy things!");
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
