
public class Dessert extends Meal {

	Dessert(int weight) {
		this.price = 4;
		if (weight < 200 || weight > 300) {
			System.out.println("Please enter a valid weight for the salad");
		} else {
			this.weight = weight;
		}
	}
}
