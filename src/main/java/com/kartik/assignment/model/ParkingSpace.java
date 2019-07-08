package com.kartik.assignment.model;


public class ParkingSpace {
	private boolean isVacant =  Boolean.TRUE;
	private int slotNumber;
	private VehicleType parkedVehicleType;
	
	public ParkingSpace(int slotNum, VehicleType parkedVehicleType) {
		this.slotNumber = slotNum;
		this.parkedVehicleType = parkedVehicleType;
	}
	public boolean isVacant() {
		return isVacant;
	}
	public void setVacant(boolean isVacant) {
		this.isVacant = isVacant;
	}
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	public VehicleType getParkedVehicleType() {
		return parkedVehicleType;
	}
	public void setParkedVehicleType(VehicleType parkedVehicleType) {
		this.parkedVehicleType = parkedVehicleType;
	}
	
	
}
