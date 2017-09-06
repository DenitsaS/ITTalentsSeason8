package estates;

public interface EstateType {
	enum ApartmentType implements EstateType{
		Studio,
		Garsoniera, 
		Dwustaen,
		Tristaen,
		Mezonet
	}
	
	enum HouseType implements EstateType{
		Etaj,
		Kyshta,
		
	}
	
	enum ParcelType implements EstateType{
		Niva,
		Polqna,
		Gora
	}
}
