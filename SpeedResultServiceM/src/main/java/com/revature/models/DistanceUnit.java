package com.revature.models;

public enum DistanceUnit {
	
	 Millimeters("millimeters"),
	 Centimeters("centimeters"),
	 Meters("meters"),
	 Kilometers("kilometers"),
	 Inches("inches"),
	 Feet("feet"),
	 Yards("yards"),
	 Miles("miles");
	
	private final String unit;
	
	DistanceUnit(String unit) {
		this.unit = unit;
	}

}
