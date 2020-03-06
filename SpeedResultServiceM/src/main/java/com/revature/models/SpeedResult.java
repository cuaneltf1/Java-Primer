package com.revature.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
//import javax.persistence.Transient;

@Entity
@Table(name = "speed_result")
public class SpeedResult {
	
	@Id
	@Column(length = 12, name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 255, name = "subject_name")
	private String subjectName;
	
	@Column(name = "speed")
	@Embedded
	// @Transient - Would prevent this from being mapped
	private Speed speed;
	
	@Column(name = "experiment_time")
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	private Timestamp experimentTime;
	
	public SpeedResult() {
		super();
	}
	
	public SpeedResult(Long id) {
		super();
		this.id = id;
	}

	public SpeedResult(String subjectName, Speed speed) {
		super();
		this.subjectName = subjectName;
		this.speed = speed;
	}

	public SpeedResult(Long id, String subjectName, Speed speed, Timestamp experimentTime) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.speed = speed;
		this.experimentTime = experimentTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Speed getSpeed() {
		return speed;
	}

	public void setSpeed(Speed speed) {
		this.speed = speed;
	}

	public Timestamp getExperimentTime() {
		return experimentTime;
	}

	public void setExperimentTime(Timestamp experimentTime) {
		this.experimentTime = experimentTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((experimentTime == null) ? 0 : experimentTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((speed == null) ? 0 : speed.hashCode());
		result = prime * result + ((subjectName == null) ? 0 : subjectName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SpeedResult)) {
			return false;
		}
		SpeedResult other = (SpeedResult) obj;
		if (experimentTime == null) {
			if (other.experimentTime != null) {
				return false;
			}
		} else if (!experimentTime.equals(other.experimentTime)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (speed == null) {
			if (other.speed != null) {
				return false;
			}
		} else if (!speed.equals(other.speed)) {
			return false;
		}
		if (subjectName == null) {
			if (other.subjectName != null) {
				return false;
			}
		} else if (!subjectName.equals(other.subjectName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "SpeedResult [id=" + id + ", subjectName=" + subjectName + ", speed=" + speed + ", experimentTime="
				+ experimentTime + "]";
	}

}
