import java.util.Date;

public abstract class VignetteCard {
	protected Color color;
	protected VehicleType type;
	protected Date dateOFIssuance;
	protected int price;
	protected ValidityType deadline;
	
	@Override 
	public String toString() {
		
		return color + " " + price;
	}
	
	public VignetteCard() {
		this.dateOFIssuance = new Date();
	}
	
	public void calculatePrice(int price){
		switch(deadline){
		case Day: this.price = price; break;
		case Month: this.price = price * 10; break;
		case Year:this.price = price * 60; break;
		}
	}
	
	abstract int timeToStick();
	
	public int getPrice() {
		return price;
	}

	public VehicleType getType() {
		return type;
	}

	public ValidityType getDeadline() {
		return deadline;
	}
	
	@SuppressWarnings("deprecation")
	public boolean IsValid(Date date){
		Date dateOfExpire = new Date();
		if(this.getDeadline() == ValidityType.Day){
			dateOfExpire = new Date(dateOFIssuance.getDay() + 1, dateOFIssuance.getMonth(),dateOFIssuance.getYear());
		} else if(this.getDeadline() == ValidityType.Month){
			dateOfExpire = new Date(dateOFIssuance.getDay(), dateOFIssuance.getMonth() + 1,dateOFIssuance.getYear());
		} else {
			dateOfExpire = new Date(dateOFIssuance.getDay(), dateOFIssuance.getMonth(),dateOFIssuance.getYear() + 1);
		}
		return date.after(dateOfExpire);

	}
}
