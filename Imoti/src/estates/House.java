package estates;

public class House  extends Estate{
	private ConstructType constructType;
	private int parkPlaces;
	private int area;
	public House(int price, EstateType type, int area, ConstructType constructType) {
		super(price, type, area, EstateKind.House);
		this.constructType = constructType;
	}

}
