package peopleinhospital;

import java.util.Random;

public class PlanOfTreatment {
	private int timeToHeal = new Random().nextInt(3) + 3;
	private String diagnosis;
	private String medicine;

	public PlanOfTreatment(String diagnosis, String medicine) {
		super();
		this.diagnosis = diagnosis;
		this.medicine = medicine;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public String getMedicine() {
		return medicine;
	}

	public int getTimeToHeal() {
		return timeToHeal;
	}

}
