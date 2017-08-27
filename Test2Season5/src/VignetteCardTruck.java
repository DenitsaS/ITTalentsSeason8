import java.util.Date;

public class VignetteCardTruck extends VignetteCard {
	public VignetteCardTruck(ValidityType deadline) {
		this.dateOFIssuance = new Date();
		this.color = Color.green;
		this.deadline = deadline;
		this.type = VehicleType.Bus;
		this.price = 7;
		calculatePrice(price);
		}

	@Override
	int timeToStick() {
		return 10;
	}
}
