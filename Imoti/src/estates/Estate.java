package estates;

import clients.Seller;

public abstract class Estate {
	public enum EstateKind implements Comparable<EstateKind> {
		Apartment, House, Parcel;
	}
	private String adress;
	private String description;
	private int price;
	private EstateType type;
	private int area;
	private EstateKind kind;

	public Estate(int price, EstateType type, int area, EstateKind kind) {
		super();
		this.price = price;
		this.type = type;
		this.area = area;
		this.kind = kind;
	}

	public int getPrice() {
		return price;
	}

	public EstateKind getKind() {
		return kind;
	}

	public EstateType getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return "Price: " + price;
	}
}
