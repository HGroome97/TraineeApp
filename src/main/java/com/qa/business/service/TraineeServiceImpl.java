package com.qa.business.service;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.ClassroomRepository;
import com.qa.persistence.repository.TraineeRepository;


@Default
public class TraineeServiceImpl implements TraineeService {

	@Inject
	private TraineeRepository repo;

	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

	public String createTrainee(String t) {
		return repo.createTrainee(t);
	}

	@Override
	public String deleteTrainee(long id) {
		return repo.deleteTrainee(id);
	}

	@Override
	public String getTrainee(long id) {
		return repo.getTrainee(id);
	}

	@Override
	public String updateTrainee(Trainee t) {
		return repo.updateTrainee(t);
	}

	
	public void setRepo(TraineeRepository repo) {
		this.repo = repo;
	}


	
}
