package com.kartik.assignment.model;

public enum VehicleType {
	
	CAR("C"),
	BIKE("B");
	
	String type;
	
	VehicleType(String type) {
		this.type = type ;
	}
	
	public String getType() {
		return type;
	}
	

}
