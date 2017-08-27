import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

public class GasStation implements IGasStation {
	static final int Vignettes_Count = 10000;
	private int moneyForTheDay;
	private ArrayList<VignetteCard> vignettes;
	
	public GasStation() {
		vignettes = new ArrayList<VignetteCard>();
		for(int i = 0; i < Vignettes_Count;i++){
			ValidityType validityType = ValidityType.Day;
			switch(new Random().nextInt(3)){
			case 0: validityType = ValidityType.Day; break;
			case 1: validityType = ValidityType.Month; break;
			case 2: validityType = ValidityType.Year; break;
			}
			
			
			switch(new Random().nextInt(3)){
			case 0: vignettes.add(new VignetteCardBus(validityType));break;
			case 1: vignettes.add(new VignetteCardCar(validityType));break;
			case 2: vignettes.add(new VignetteCardTruck(validityType));break;
			}
		}
		
		vignettes.sort(new Comparator<VignetteCard>() {

			@Override
			public int compare(VignetteCard o1, VignetteCard o2) {
				return ((Integer)o1.getPrice()).compareTo(o2.getPrice());
			}
		});
	}
	
	@Override
	public VignetteCard buyVignette(VehicleType type, ValidityType duration) {
		for(VignetteCard vignetteCard : vignettes) {
			if(vignetteCard.getType() == type && vignetteCard.getDeadline() == duration){
				moneyForTheDay+=vignetteCard.getPrice();
				vignettes.remove(vignetteCard);
				return vignetteCard;
			}
		}
		
		
		return null;
	}

	public ArrayList<VignetteCard> getVignettes() {
		return vignettes;
	}

}
