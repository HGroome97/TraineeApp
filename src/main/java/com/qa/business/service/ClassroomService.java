package com.qa.business.service;

import com.qa.persistence.domain.Classroom;

public interface ClassroomService {

	String getAllClassrooms();
	String createClassroom(String cr);
	String getClassroom(long id);
	String deleteClassroom(long id);
	String updateClassroom(Classroom cr);
	
}
