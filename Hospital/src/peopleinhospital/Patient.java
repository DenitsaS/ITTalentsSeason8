package peopleinhospital;

import java.util.Random;

import hospital.Room;
import hospital.WardType;

public class Patient extends ContactInfo {
	private boolean isWoman;
	private String diagnose;
	private PlanOfTreatment plan;
	private int timeSpendInHospital;
	private Room room;
	private Doctor doctor;
	private int age;

	public Patient(String name, boolean isWoman) {
		super(name);
		this.age = new Random().nextInt(96) + 1;
		this.isWoman = isWoman;
		this.room = new Room(WardType.Cardiology, 7);
		this.timeSpendInHospital = 0;
	}

	public int getAge() {
		return age;
	}

	public PlanOfTreatment getPlan() {
		return plan;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return getName() + " of gender " + (isWoman ? " woman " : "male");
	}

	public String getDiagnose() {
		return diagnose;
	}

	public int getTimeSpendInHospital() {
		return timeSpendInHospital;
	}

	public void increaseTimeSpendInHospital() {
		this.timeSpendInHospital++;
	}

	public void addRoom(Room room) {
		if (room != null) {
			this.room = room;
		}
	}

	public Room getRoom() {
		return room;
	}

	public void setPlan(PlanOfTreatment plan) {
		this.diagnose = plan.getDiagnosis();
		this.plan = plan;
	}
}
