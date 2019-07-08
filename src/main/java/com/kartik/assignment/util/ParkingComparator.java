package com.kartik.assignment.util;

import java.util.Comparator;
import com.kartik.assignment.model.ParkingSpace;

public class ParkingComparator implements Comparator<ParkingSpace>{
	
	public int compare(ParkingSpace o1, ParkingSpace o2) {
		if(o1.getSlotNumber() < o2.getSlotNumber() ){
			return -1;
		} else if(o1.getSlotNumber() > o2.getSlotNumber()){
			return 1;
		}
		return 0;
	}

}
