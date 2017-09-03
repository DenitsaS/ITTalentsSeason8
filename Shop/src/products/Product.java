package products;

public abstract class Product {
	private String name;
	private int price;
	private int count;
	
	public Product(String name, int price) {
		super();
		if(name != null && !name.equals("")){
			this.name = name;
		} else {
			this.name = "bezime";
		}
		if(price > 0){
			this.price = price;
		} else {
			this.price = 3;
		}
		
	}

	public abstract int getAvailability();
	public abstract void setAvailability(int availability);

	
	@Override
	public boolean equals(Object obj) {
		return this.name.equals(((Product)obj).name);
	}
	
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
