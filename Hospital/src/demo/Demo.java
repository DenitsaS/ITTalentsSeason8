package demo;

import java.util.Random;

import hospital.Hospital;
import hospital.WardType;
import peopleinhospital.Patient;

public class Demo {
	final static int countOfPatients = 5;

	public static void main(String[] args) {

		final String[] names = { "Deni", "Galq", "Stefi", "Mitko ", "Gosho ", "Pesho" };
		Hospital hospital = new Hospital();

		for (int i = 0; i < countOfPatients; i++) {
			Patient patient = new Patient(names[new Random().nextInt(names.length)], true);
			if (hospital.addPatient(patient)) {
				System.out.println(patient + " with " + patient.getDiagnose() + " was admitted. Doctor "
						+ patient.getDoctor().getName());
			}

		}
		for (int i = 0; i < 10; i++) {

			System.out.println("\nDAY " + (i + 1));
			hospital.startDay();

		}

		for (int i = 0; i < 3; i++) {
			int freeBedCount = 0;
			for (int j = 0; j < 10; j++) {
				freeBedCount += 3 - hospital.getRooms().get(i + j).getCountOFOccupiedBeds();
			}
			System.out.println(WardType.values()[i] + " : " + freeBedCount);
		}

		for (int i = 0; i < hospital.getPatients().size(); i++) {
			if (hospital.getPatients().get(i)
					.getTimeSpendInHospital() == hospital.getPatients().get(i).getPlan().getTimeToHeal() - 1) {
				System.out.println(hospital.getPatients().get(i).getName());
			}
		}
	}
}
