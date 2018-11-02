package com.qa.business.service;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.ClassroomRepository;


@Default
public class ClassroomServiceImpl implements ClassroomService {

	@Inject
	private ClassroomRepository repo;

	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}

	public String createClassroom(String cr) {
		return repo.createClassroom(cr);
	}

	@Override
	public String deleteClassroom(long id) {
		return repo.deleteClassroom(id);
	}

	@Override
	public String getClassroom(long id) {
		return repo.getClassroom(id);
	}

	@Override
	public String updateClassroom(Classroom cr) {
		return repo.updateClassroom(cr);
	}

	
	public void setRepo(ClassroomRepository repo) {
		this.repo = repo;
	}


	
}
