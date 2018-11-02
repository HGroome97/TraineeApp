package com.qa.persistence.repository;

import com.qa.persistence.domain.Classroom;

public interface ClassroomRepository {

	String getAllClassrooms();
	String createClassroom(String cr);
	String getClassroom(long id);
	String deleteClassroom(long id);
	String updateClassroom(Classroom cr);
}