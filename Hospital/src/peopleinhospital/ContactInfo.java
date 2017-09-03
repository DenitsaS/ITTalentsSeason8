package peopleinhospital;

public abstract class ContactInfo {
	private String name;
	private String number;

	public ContactInfo(String name) {
		setName(name);
	}

	public boolean isStringValid(String s) {
		return s != null && !s.equals("");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (isStringValid(name)) {
			this.name = name;
		} else {
			this.name = "default";
		}
	}
}
