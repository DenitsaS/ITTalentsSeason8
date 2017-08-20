
public class MainDish extends Meal {

	MainDish(int weight) {
		this.price = 9;
		if (weight < 400 || weight > 800) {
			System.out.println("Please enter a valid weight for the main dish");
		} else {
			this.weight = weight;
		}
	}
}
