package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long classroomId;
	private String trainer;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "traineeId")
	private List<Trainee> trainees = new ArrayList<>();
	
	
	public Classroom() {
		
	}
	
	public Classroom(int classroomId, String trainer, List<Trainee> trainees) {
		this.classroomId = classroomId;
		this.trainer = trainer;
		this.trainees = trainees;
	}

	public Classroom(String trainer, List<Trainee> trainees) {
		this.trainer = trainer;
		this.trainees = trainees;
	}

	
	
	public long getClassroomId() {
		return classroomId;
	}
	public void setClassroomId(long classroomId) {
		this.classroomId = classroomId;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public List<Trainee> getTrainees() {
		return trainees;
	}
	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}

	@Override
	public String toString() {
		return "Classroom [classroomId=" + classroomId + ", trainer=" + trainer + ", trainees=" + trainees + "]";
	}
	
}
