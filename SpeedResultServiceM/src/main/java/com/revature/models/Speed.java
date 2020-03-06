package com.revature.models;

import java.time.Duration;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Speed {
	
	private Duration duration;
	
	@Embedded
	private Distance distance;
	
	public Speed() {
		super();
	}

	public Speed(Duration duration, Distance distance) {
		super();
		this.duration = duration;
		this.distance = distance;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Speed)) {
			return false;
		}
		Speed other = (Speed) obj;
		if (distance == null) {
			if (other.distance != null) {
				return false;
			}
		} else if (!distance.equals(other.distance)) {
			return false;
		}
		if (duration == null) {
			if (other.duration != null) {
				return false;
			}
		} else if (!duration.equals(other.duration)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Speed [duration=" + duration + ", distance=" + distance + "]";
	}
	
}
