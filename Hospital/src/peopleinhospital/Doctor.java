package peopleinhospital;

import java.util.Random;

public class Doctor extends ContactInfo {
	private boolean isFree;
	private Patient patient;
	private String specialization;

	public Doctor(String name) {
		super(name);
		this.isFree = true;
		this.specialization = "";
		this.patient = new Patient("", true);
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public Patient getPatient() {
		return patient;
	}

	public void addPatient(Patient patient) {
		if (patient != null) {
			this.patient = patient;
		}
	}

	public PlanOfTreatment createPlan() {
		final String[] diagnosis = { "tahikardiq", "schupeno kolqno", "svinski grip" };
		final String[] medicine = { "Analgin", "Fervex", "Aspirin" };
		return new PlanOfTreatment(diagnosis[new Random().nextInt(diagnosis.length)],
				medicine[new Random().nextInt(medicine.length)]);
	}

}
