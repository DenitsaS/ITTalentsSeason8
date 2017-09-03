package products;

public class ProductByCount extends Product {
	private int count;
	public ProductByCount(String name, int price, int count) {
		super(name, price);
		if(count > 0){
			this.count = count;
		}
	}
	@Override
	public int getAvailability() {
		// TODO Auto-generated method stub
		return count;
	}
	@Override
	public void setAvailability(int availability) {
		this.count = availability;
	}

}
