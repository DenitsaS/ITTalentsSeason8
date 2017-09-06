package agency;

public abstract class ContactInfo {
	String name;
	String number;
	public ContactInfo(String name) {
		super();
		if(isDataValid(name)){
			this.name = name;
		}
		
		number = "28942892";
	}
	
	public boolean isDataValid(String s){
		if(s != null && !s.equals("")) {
			return true;
		}
		return false;
	}
}
