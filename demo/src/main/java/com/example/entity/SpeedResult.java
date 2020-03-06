package com.example.entity;

import java.security.Timestamp;
import java.time.Duration;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class SpeedResult {
	@Id
	private Long id;     
	private String subjectName;  
	@Type(type = "Speed.class")
	private Speed speed;     
	private Timestamp experimentTime;
	public DistanceUnit getDistanceUnit() {
		return speed.getDistance().getDistanceUnit();
	}
	
	public void setDistanceUnit(DistanceUnit distanceUnit) {
		speed.getDistance().setDistanceUnit(distanceUnit);
	}
	
	public Double getUnit() {
		return speed.getDistance().getUnit();
	}
	
	public void setUnit(Double unit) {
		speed.getDistance().setUnit(unit);
	}
	
} 

class Speed { 
    private Duration duration;
    private Distance distance;
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	public Distance getDistance() {
		return distance;
	}
	public void setDistance(Distance distance) {
		this.distance = distance;
	}
} 

class Distance {     
	private DistanceUnit distanceUnit;     
	private Double unit;
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

} 


