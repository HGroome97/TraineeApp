package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Trainee {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long traineeId;
	
	private String fName;
	private String lName;
	
	
	//@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "classroomid")
	private long classroomId;
	

	
	public Trainee() {
		
	}
	
	public Trainee(long classroomId, String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
		this.classroomId = classroomId;
	}

	public Trainee(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public long getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(long traineeId) {
		this.traineeId = traineeId;
	}

	public long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(long classroomId) {
		this.classroomId = classroomId;
	}

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", fName=" + fName + ", lName=" + lName + ", classroomId="
				+ classroomId + "]";
	}

	
	
}
