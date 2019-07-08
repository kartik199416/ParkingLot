package com.kartik.assignment.util;

import java.util.HashMap;
import java.util.PriorityQueue;

import com.kartik.assignment.model.ParkingSpace;
import com.kartik.assignment.model.Vehicle;
import com.kartik.assignment.model.VehicleType;

public class ParkingLot {

	PriorityQueue<ParkingSpace> carParkingQueue;
	PriorityQueue<ParkingSpace> bikeParkingQueue;
	HashMap<String, ParkingSpace> occupiedParking = new HashMap<String, ParkingSpace>();

	/**
	 * Initialize parking space for m cars and n bikes.
	 * 
	 * @param carParkSize
	 *            - car parking size
	 * @param bikeParkSize
	 *            - bike parking size
	 */
	public ParkingLot(int carParkSize, int bikeParkSize) {
		carParkingQueue = new PriorityQueue<ParkingSpace>(carParkSize, new ParkingComparator());
		bikeParkingQueue = new PriorityQueue<ParkingSpace>(bikeParkSize, new ParkingComparator());
		for (int i = 0; i < carParkSize; i++) {
			carParkingQueue.add(new ParkingSpace(i+1, VehicleType.CAR));
		}
		for (int i = 0; i < bikeParkSize; i++) {
			bikeParkingQueue.add(new ParkingSpace(i+1, VehicleType.BIKE));
		}
	}

	public boolean park(Vehicle v) {
		if (VehicleType.CAR.equals(v.getType())) {
			if (!carParkingQueue.isEmpty()) {
				ParkingSpace park = carParkingQueue.remove();
				occupiedParking.put(v.getLicensePlate(), park);
				park.setVacant(Boolean.FALSE);
				System.out.println("Parked....");
				return Boolean.TRUE;
			}
			System.out.println("Car Parking Full");
		}
		if (VehicleType.BIKE.equals(v.getType())) {
			if (!bikeParkingQueue.isEmpty()) {
				ParkingSpace park = bikeParkingQueue.remove();
				occupiedParking.put(v.getLicensePlate(), park);
				park.setVacant(Boolean.FALSE);
				System.out.println("Parked....");
				return Boolean.TRUE;
			}
			System.out.println("Car Parking Full");
		}
		return false;

	}

	public boolean unpark(Vehicle v) {
		if (!occupiedParking.isEmpty() && occupiedParking.containsKey(v.getLicensePlate())) {
			ParkingSpace freeSpace = occupiedParking.remove(v.getLicensePlate());
			if (VehicleType.CAR.equals(freeSpace.getParkedVehicleType())) {
				carParkingQueue.add(freeSpace);
			} else {
				bikeParkingQueue.add(freeSpace);
			}
			System.out.println("UnParked....");
			freeSpace.setVacant(Boolean.TRUE);
		}
		System.out.println("No Vehicle found with this License Plate");
		return Boolean.FALSE;
	}
}
