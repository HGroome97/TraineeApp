package com.qa.persistence.repository;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainee;

public interface TraineeRepository {

	String getAllTrainees();
	String createTrainee(String cr);
	String getTrainee(long id);
	String deleteTrainee(long id);
	String updateTrainee(Trainee t);
}