package com.kartik.assignment.util;

import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.kartik.assignment.model.ParkingSpace;
import com.kartik.assignment.model.VehicleType;

public class ParkingMonitor {

	private ParkingLot parkingLot;

	public ParkingMonitor(ParkingLot lot) {
		this.parkingLot = lot;
	}

	public void listOfBikeParked() {
		if (!parkingLot.occupiedParking.isEmpty()) {
			List<Entry<String, ParkingSpace>> tempList = parkingLot.occupiedParking.entrySet().stream()
					.filter(entry -> entry.getValue().getParkedVehicleType().equals(VehicleType.BIKE))
					.collect(Collectors.toList());
			if (!tempList.isEmpty()) {
				tempList.forEach(entry -> System.out.println(entry.getKey()));
			} else {
				System.out.println("Bike Parking Empty");
			}
			//
		} else {
			System.out.println("Parking Empty");
		}

	}

	public void getParkedBikeSlot(String plate) {
		if (!parkingLot.occupiedParking.isEmpty() && parkingLot.occupiedParking.containsKey(plate)
				&& VehicleType.BIKE.equals(parkingLot.occupiedParking.get(plate).getParkedVehicleType())) {
			System.out.println("Parking Slot : B" + parkingLot.occupiedParking.get(plate).getSlotNumber());
		} else {
			System.out.println("No Bike Found");
		}
	}

	public void listOfCarParked() {
		if (!parkingLot.occupiedParking.isEmpty()) {
			List<Entry<String, ParkingSpace>> tempList = parkingLot.occupiedParking.entrySet().stream()
					.filter(entry -> entry.getValue().getParkedVehicleType().equals(VehicleType.CAR))
					.collect(Collectors.toList());
			if (!tempList.isEmpty()) {
				tempList.forEach(entry -> System.out.println(entry.getKey()));
			} else {
				System.out.println("Car Parking Empty");
			}
		} else {
			System.out.println("Bike Parking Empty");
		}
	}

	public void getCarDetails(String plate) {
		boolean parked = parkingLot.occupiedParking.entrySet().stream().filter(entry -> plate.equals(entry.getKey())
				&& VehicleType.CAR.equals(entry.getValue().getParkedVehicleType())).findFirst().isPresent();
		if (parked) {
			System.out.println("Parked in slot : C" + parkingLot.occupiedParking.get(plate).getSlotNumber());
		} else {
			System.out.println("No Car Found");
		}

	}
}
