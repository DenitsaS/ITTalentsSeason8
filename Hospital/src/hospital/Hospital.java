package hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import peopleinhospital.Doctor;
import peopleinhospital.Nurse;
import peopleinhospital.Patient;

public class Hospital {
	private static final int countOfRooms = 10;
	private static final int countOfWards = 3;
	private static final int countOfDoctors = 10;
	private static final int countOfNurses = 3;

	private final String[] names = { "Vesi", "Asq", "Rado ", "Petko ", "Gosho ", "Angel" };
	private List<Cartoon> cartoons;
	private List<Nurse> nurses;
	private List<Patient> patients;
	private List<Doctor> doctors;
	private List<Room> rooms;

	public Hospital() {
		patients = new ArrayList<Patient>();
		doctors = new ArrayList<Doctor>();

		for (int i = 0; i < countOfDoctors; i++) {
			doctors.add(new Doctor(names[new Random().nextInt(names.length)]));
		}

		rooms = new ArrayList<Room>();
		for (int i = 0; i < countOfWards; i++) {
			int roomNumber = 1;
			for (int j = 0; j < countOfRooms; j++) {
				rooms.add(new Room(WardType.values()[i], roomNumber++));
			}
		}

		nurses = new ArrayList<Nurse>();
		for (int i = 0; i < countOfNurses; i++) {
			nurses.add(new Nurse((names[new Random().nextInt(names.length)]), WardType.values()[i]));
		}
		cartoons = new ArrayList<Cartoon>();

	}

	public boolean addPatient(Patient patient) {
		boolean result = false;
		if (hasDoctor(patient)) {

			cartoons.add(new Cartoon(patient.getName(), patient.getAge()));
			patient.setPlan(patient.getDoctor().createPlan());
			result = false;
		}

		if (getFreeRoomIndex(patient) != -1) {
			patients.add(patient);
			patient.addRoom(rooms.get(getFreeRoomIndex(patient)));
			addPatientToRoomIndex(patient, getFreeRoomIndex(patient));
			result = true;
		}
		return result;

	}

	public boolean hasDoctor(Patient patient) {
		if (patient != null) {
			for (Doctor doctor : doctors) {
				if (doctor.isFree()) {
					patient.setDoctor(doctor);
					doctor.setFree(false);
					doctor.addPatient(patient);
					return true;
				}
			}
		}
		System.out.println("There are no free doctors, you need to wait");
		return false;
	}

	private int getFreeRoomIndex(Patient patient) {
		for (int i = 0; i < rooms.size(); i++) {
			if (rooms.get(i).getCountOFOccupiedBeds() == 0) {
				return i;
			} else if (rooms.get(i).getCountOFOccupiedBeds() < 3) {
				if (patient.getDiagnose().equals(rooms.get(i).getPatients().get(0).getDiagnose())) {
					return i;
				}
			}
		}
		System.out.println("There are no free rooms, you need to wait");
		return -1;

	}

	private void addPatientToRoomIndex(Patient patient, int index) {
		rooms.get(index).addPatient(patient);

	}

	public void startDay() {
		for (int i = 0; i < patients.size(); i++) {
			if (patients.get(i).getPlan().getTimeToHeal() > patients.get(i).getTimeSpendInHospital()) {
				patients.get(i).increaseTimeSpendInHospital();
			} else {
				System.out.println(patients.get(i) + " with " + patients.get(i).getDiagnose() + " was released");
				patients.get(i).getRoom().removePatient(patients.get(i));
				patients.remove(i);
				i--;
			}
		}

		for (int i = 0; i < rooms.size(); i++) {
			for (int j = 0; j < nurses.size(); j++) {
				if (rooms.get(i).getWard() == nurses.get(j).getWard()) {
					for (int k = 0; k < rooms.get(i).getPatients().size(); k++) {
						System.out.println("Nurse " + nurses.get(j).getName() + " gave "
								+ rooms.get(i).getPatients().get(k).getName() + " "
								+ rooms.get(i).getPatients().get(k).getPlan().getMedicine());
					}
				}
			}
		}

		for (int i = 0; i < patients.size(); i++) {
			System.out.println("Doctor " + patients.get(i).getDoctor().getName() + " visited "
					+ patients.get(i).getName() + " in room " + patients.get(i).getRoom().getRoomNumber() + " in ward "
					+ patients.get(i).getRoom().getWard());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Patient> getPatients() {
		return patients;
	}

	public List<Room> getRooms() {
		return rooms;
	}
}
