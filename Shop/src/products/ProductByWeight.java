package products;

public class ProductByWeight extends Product{
	private int weight;
	public ProductByWeight(String name, int price, int weight) {
		super(name, price);
		if(weight > 0){
			this.weight = weight;
		}
	}
	@Override
	public int getAvailability() {
		// TODO Auto-generated method stub
		return weight;
	}
	@Override
	public void setAvailability(int availability) {
		this.weight = availability;
	}

}
