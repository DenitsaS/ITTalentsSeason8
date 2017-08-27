
public class Vehicle {
	private String model;
	private VignetteCard vignetteCard;
	private int yearOfProduction;
	private VehicleType type;
	
	public Vehicle( int yearOfProduction, VehicleType type) {
		super();
		this.yearOfProduction = yearOfProduction;
		this.type = type;
	}

	public void setVignetteCard(VignetteCard vignetteCard) {
		if(vignetteCard != null && vignetteCard.type != type){
		this.vignetteCard = vignetteCard;
		}
	}

	public VehicleType getType() {
		return type;
	}
}
