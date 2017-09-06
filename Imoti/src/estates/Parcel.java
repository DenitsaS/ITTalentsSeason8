package estates;

public class Parcel extends Estate {
	private boolean isRegulated;
	
	public Parcel(int price, EstateType type, int area, boolean isRegulated) {
		super(price, type, area, EstateKind.Parcel);
		this.isRegulated = isRegulated;
	}

}
