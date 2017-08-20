import java.util.List;

public class Menu {
	private List<FoodAndDrink> menuProducts;

	public List<FoodAndDrink> getMenuProducts() {
		return menuProducts;
	}

	public Menu(List<FoodAndDrink> foodAndDrinks) {
		this.menuProducts = foodAndDrinks;
	}
}
