import java.util.Random;

public class Demo {

	public static void main(String[] args) {
		GasStation lukoil = new GasStation();
		for (int i = 0; i < lukoil.getVignettes().size(); i++) {
			System.out.println(lukoil.getVignettes().get(i).toString());
		}
		String[] names = {"Pesho", "Gesho", "Mina", "Ginka", "Penka", "Gancho", "Puhi"};
		
		Driver [] drivers = new Driver [20];
		for (int i = 0; i < 20; i++) {
			drivers[i]  = new Driver(new Random().nextInt(1000)+ 100, lukoil, names[new Random().nextInt(7)]);
		}
		
		
		Vehicle [] vehicles = new Vehicle [200];
		for (int i = 0; i < vehicles.length; i++) {

			VehicleType vehicleType = VehicleType.Bus;
			switch(new Random().nextInt(3)){
			case 0: vehicleType = VehicleType.Bus; break;
			case 1: vehicleType = VehicleType.Car; break;
			case 2: vehicleType = VehicleType.Truck; break;
			}
			vehicles[i] = new Vehicle(new Random().nextInt(2017) + 1985, vehicleType);
		}
		int counter = 0;
		for (int i = 0; i < drivers.length; i++) {
			for(int j = 0; j < 10; j++){
				drivers[i].setVehicle(vehicles[counter++]);
			}
		}
		
		for(int i = 0; i < drivers.length; i++){
			if(i % 3 == 0){
				for(int j = 0; j < 5; j++){
					drivers[i].buyVignette(drivers[i].getVehicles().get(j).getType());
				}
			} else {

				for(int j = 0; j < 10; j++){
					drivers[i].buyVignette(drivers[i].getVehicles().get(j).getType());
				}
			} 
		}
		
		
		for (int i = 0; i < drivers.length; i++) {
			System.out.println(drivers[i].toString());
		}
		
		
		for (int i = 0; i < lukoil.getVignettes().size(); i++) {
			System.out.println(lukoil.getVignettes().get(i).toString());	
		}
	}
	
}
