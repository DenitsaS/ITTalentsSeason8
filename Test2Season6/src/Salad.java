
public class Salad extends Meal {

	Salad(int weight) {
		this.price = 5;
		if (weight < 300 || weight > 600) {
			System.out.println("Please enter a valid weight for the salad");
		} else {
			this.weight = weight;
		}
	}
}
