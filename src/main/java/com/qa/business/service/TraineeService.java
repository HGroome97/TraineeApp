package com.qa.business.service;

import com.qa.persistence.domain.Trainee;

public interface TraineeService {

	String getAllTrainees();
	String createTrainee(String cr);
	String getTrainee(long id);
	String deleteTrainee(long id);
	String updateTrainee(Trainee t);
	
}
