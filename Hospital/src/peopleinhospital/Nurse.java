package peopleinhospital;

import hospital.WardType;

public class Nurse extends ContactInfo {
	private int lengthOfService;
	private WardType ward;

	public Nurse(String name, WardType ward) {
		super(name);
		this.ward = ward;
	}

	public WardType getWard() {
		return ward;
	}

}
