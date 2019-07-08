package com.kartik.assignment.app;

import java.util.Scanner;

import com.kartik.assignment.model.Vehicle;
import com.kartik.assignment.model.VehicleType;
import com.kartik.assignment.util.ParkingLot;
import com.kartik.assignment.util.ParkingMonitor;

public class ParkingManagementApp {

	static ParkingLot parkingLot;
	static ParkingMonitor parkingMonitor;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		initializeParking(scanner);
		while (true) {
			parkingOperations(scanner);
		}

	}

	private static void parkingOperations(Scanner scanner) {
		System.out.println("Choose user type number :");
		System.out.println("1 - Admin");
		System.out.println("2 - Customer ");
		int userType = scanner.nextInt();
		switch (userType) {
		case 1:
			adminOptions(scanner);
			break;
		case 2:
			customerOptions(scanner);
			break;
		default:
			System.out.println("IncorrectInput");
			parkingOperations(scanner);
		}
	}

	private static void customerOptions(Scanner scanner) {
		System.out.println("Choose below option :");
		System.out.println("1 - Park");
		System.out.println("2 - UnPark ");
		Vehicle v;
		int parkFlag = scanner.nextInt();
		switch (parkFlag) {
		case 1:
			v = enterVehicleDetails(scanner);
			parkingLot.park(v);
			break;
		case 2:
			v = enterVehicleDetails(scanner);
			parkingLot.unpark(v);
			break;
		default:
			System.out.println("IncorrectInput");
			customerOptions(scanner);
		}
	}

	private static Vehicle enterVehicleDetails(Scanner scanner) {
		System.out.println("Enter Vehicle Details:");
		System.out.println("Type : 1-car, 2 - bike");
		Vehicle v = new Vehicle();
		int vType = scanner.nextInt();
		if (vType == 1) {
			v.setType(VehicleType.CAR);
		} else if (vType == 2) {
			v.setType(VehicleType.BIKE);
		} else {
			System.out.println("IncorrectInput");
			enterVehicleDetails(scanner);
		}
		System.out.println("License Number ");
		v.setLicensePlate(scanner.next());

		return v;
	}

	private static void adminOptions(Scanner scanner) {
		System.out.println("Enter option for monitor options");
		System.out.println("1 - All parked bike license plates list");
		System.out.println("2 - All parked cars license plates list");
		System.out.println("3 - Find bike with Given License plate ");
		System.out.println("4 - Find car with Given License plate ");

		int operation = scanner.nextInt();
		String plate;
		switch (operation) {
		case 1:
			parkingMonitor.listOfBikeParked();
			break;
		case 2:
			parkingMonitor.listOfCarParked();
			break;
		case 3:
			plate = enterNumber(scanner, VehicleType.BIKE);
			parkingMonitor.getParkedBikeSlot(plate);
			break;
		case 4:
			plate = enterNumber(scanner, VehicleType.CAR);
			parkingMonitor.getCarDetails(plate);
			break;
		default:
			System.out.println("Incorrect Input");
			adminOptions(scanner);
		}

	}

	private static String enterNumber(Scanner scanner, VehicleType type) {
		System.out.println("Enter " + type + "number : ");
		return scanner.next();
	}

	private static void initializeParking(Scanner scanner) {
		System.out.println("Welcome to Car/Bike Parking....");
		System.out.println("Admin Console --> Parking Configuration");

		System.out.println("Enter car parking Size...");
		int carParkSize = scanner.nextInt();
		System.out.println("Enter  bike parking Size...");
		int bikeParkSize = scanner.nextInt();

		System.out.println("Initialize Parking Space....");
		parkingLot = new ParkingLot(carParkSize, bikeParkSize);
		parkingMonitor = new ParkingMonitor(parkingLot);
		System.out.println("Initialization completed for Parking Space....");

	}
}
