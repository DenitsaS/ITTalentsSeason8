import java.util.ArrayList;
import java.util.Random;
import java.util.Date;


public class Driver {
	private String name;
	private  ArrayList<VignetteCard> vignetteCardsBought;
	private  ArrayList<Vehicle> vehicles;
	private GasStation gasStation;
	private int money;
	
	Driver(int money, GasStation gasStation, String name){
		vignetteCardsBought = new ArrayList<VignetteCard>();
		vehicles = new ArrayList<Vehicle>();
		if(name != null || !name.equals("")){
			this.name = name;
		} else {
			this.name = "Deniii";
		}
		this.gasStation = gasStation;
		if(money > 0){
			this.money = money;
		} else {
			money = 10;
		}
	}
	
	
	@Override
	public String toString() {	
		return name + "is driving  " + vehicles.size() + " vehicles, has  has " + money + " leva left.\n";
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}
	
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public void buyVignette(VehicleType type){
		ValidityType validityType = ValidityType.Day;
		switch(new Random().nextInt(3)){
		case 0: validityType = ValidityType.Day; break;
		case 1: validityType = ValidityType.Month; break;
		case 2: validityType = ValidityType.Year; break;
		}
		vignetteCardsBought.add(gasStation.buyVignette(type, validityType));

	}
	
	public int expiredVignetteCards(Date date){
		int countOfExpired = 0;
		for (int i = 0; i < vignetteCardsBought.size(); i++) {
			if(vignetteCardsBought.get(i).IsValid(date)){
				countOfExpired++;
			}
		}
		return countOfExpired;
	}
}
