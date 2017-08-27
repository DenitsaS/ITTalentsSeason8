import java.util.Date;

public class VignetteCardCar extends VignetteCard{
	
	
	public VignetteCardCar(ValidityType deadline) {
		this.dateOFIssuance = new Date();
		this.color = Color.red;
		this.type = VehicleType.Car;
		this.deadline = deadline;
		this.price = 5;
		calculatePrice(price);
	}

	@Override
	int timeToStick() {
		return 5;
	}
}
