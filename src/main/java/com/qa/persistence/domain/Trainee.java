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
	
	private String fName;
	private String lName;
	
	
	//@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "post_id")
	private long classroomId;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	public Trainee() {
		
	}
	
	public Trainee(int accountNumber, String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
		this.id = accountNumber;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(long classroomId) {
		this.classroomId = classroomId;
	}

	@Override
	public String toString() {
		return "Account [fName=" + fName + ", lName=" + lName + ", accountNumber=" + id + "]";
	}
}
