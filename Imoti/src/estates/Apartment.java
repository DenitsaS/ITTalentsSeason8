package estates;

public class Apartment extends Estate{

	private ConstructType constructType;
	public Apartment(int price, EstateType type, int area,  ConstructType constructType) {
		super(price, type, area,EstateKind.Apartment);
		this.constructType = constructType;
	}
	
}
