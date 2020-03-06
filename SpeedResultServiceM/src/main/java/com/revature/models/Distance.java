package com.revature.models;

import javax.persistence.Embeddable;

@Embeddable
public class Distance {
	
	private DistanceUnit distanceUnit;
	private Double unit;
	
	public Distance() {
		super();
	}

	public Distance(DistanceUnit distanceUnit, Double unit) {
		super();
		this.distanceUnit = distanceUnit;
		this.unit = unit;
	}

	public DistanceUnit getDistanceUnit() {
		return distanceUnit;
	}

	public void setDistanceUnit(DistanceUnit distanceUnit) {
		this.distanceUnit = distanceUnit;
	}

	public Double getUnit() {
		return unit;
	}

	public void setUnit(Double unit) {
		this.unit = unit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distanceUnit == null) ? 0 : distanceUnit.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Distance)) {
			return false;
		}
		Distance other = (Distance) obj;
		if (distanceUnit != other.distanceUnit) {
			return false;
		}
		if (unit == null) {
			if (other.unit != null) {
				return false;
			}
		} else if (!unit.equals(other.unit)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Distance [distanceUnit=" + distanceUnit + ", unit=" + unit + "]";
	}
	
}
