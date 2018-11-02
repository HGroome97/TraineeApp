package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassroomRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonOb;
	
	public String getAllClassrooms() {
		Query query = manager.createQuery("Select cr FROM Classroom cr");
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
		return jsonOb.getJSONForObject(classrooms);
	}
	
	@Transactional(REQUIRED)
	public String createClassroom(String classroom) {
		Classroom aClassroom = jsonOb.getObjectForJSON(classroom, Classroom.class);
		manager.persist(aClassroom);
		return "{\"message\": \"classroom has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteClassroom(long id) {
		Classroom classroomInDB = findClassroom(id);
		if (classroomInDB != null) {
			manager.remove(classroomInDB);
		}
		return "{\"message\": \"classroom sucessfully deleted\"}";
	}

	public String getClassroom(long id) {
		Classroom classroomInDB = findClassroom(id);
		return jsonOb.getJSONForObject(classroomInDB);
	}
	
	@Transactional(REQUIRED)
	public String updateClassroom(Classroom cr) {
		Classroom classroomInDB = findClassroom(cr.getClassroomId());
		classroomInDB.setTrainer(cr.getTrainer());
		classroomInDB.setTrainees(cr.getTrainees());
		return "{\"message\": \"classroom has been sucessfully updated\"}";
	}
	
	
	private Classroom findClassroom(long id) {
		return manager.find(Classroom.class, id);
	}


	public void setManager(EntityManager manager) {
		this.manager = manager;
	}



		
}
