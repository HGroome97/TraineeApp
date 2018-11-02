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
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TraineeDBRepository implements TraineeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonOb;
	
	public String getAllTrainees() {
		Query query = manager.createQuery("Select t FROM trainee t");
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return jsonOb.getJSONForObject(trainees);
	}
	
	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainee aTrainee = jsonOb.getObjectForJSON(trainee, Trainee.class);
		manager.persist(aTrainee);
		return "{\"message\": \"trainee has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteTrainee(long id) {
		Trainee traineeInDB = findTrainee(id);
		if (traineeInDB != null) {
			manager.remove(traineeInDB);
		}
		return "{\"message\": \"trainee sucessfully deleted\"}";
	}

	public String getTrainee(long id) {
		Trainee traineeInDB = findTrainee(id);
		return jsonOb.getJSONForObject(traineeInDB);
	}
	
	@Transactional(REQUIRED)
	public String updateTrainee(Trainee t) {
		Trainee traineeInDB = findTrainee(t.getId());
		traineeInDB.setfName(t.getfName());
		traineeInDB.setlName(t.getlName());
		traineeInDB.setClassroomId(t.getClassroomId());
		return "{\"message\": \"trainee has been sucessfully updated\"}";
	}
	
	
	private Trainee findTrainee(long id) {
		return manager.find(Trainee.class, id);
	}


	public void setManager(EntityManager manager) {
		this.manager = manager;
	}


		
}
