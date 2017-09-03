package hospital;

import java.util.ArrayList;
import java.util.List;

import peopleinhospital.Patient;

public class Room {
	private WardType ward;
	private List<Patient> patients;
	private int countOFOccupiedBeds;
	private int roomNumber;

	public Room(WardType ward, int roomNumber) {
		this.roomNumber = roomNumber;
		this.ward = ward;
		countOFOccupiedBeds = 0;
		this.patients = new ArrayList<Patient>();
	}

	public Room() {
	}

	public WardType getWard() {
		return ward;
	}

	public int getCountOFOccupiedBeds() {
		return countOFOccupiedBeds;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void addPatient(Patient patient) {
		this.countOFOccupiedBeds++;
		patients.add(patient);
	}

	public void removePatient(Patient patient) {
		this.countOFOccupiedBeds--;
		for (int i = 0; i < patients.size(); i++) {
			if (patient == patients.get(i)) {
				patients.remove(i);
			}
		}
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public WardType getWArd() {
		return ward;
	}
}
