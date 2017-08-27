import java.util.Date;

public class VignetteCardBus extends VignetteCard {
	
	public VignetteCardBus(ValidityType deadline) {
		this.color = Color.green;
		this.deadline = deadline;
		this.type = VehicleType.Bus;
		this.price = 9;
		this.dateOFIssuance = new Date();
		calculatePrice(price);
	}

	@Override
	int timeToStick() {
		return 20;
	}
}
