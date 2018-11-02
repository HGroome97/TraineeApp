package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.qa.business.service.ClassroomService;
import com.qa.business.service.TraineeService;
import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Path("/trainee")
public class TraineeEndpoint {
	
	@Inject
	private TraineeService service;

	
	@Inject
	private JSONUtil jsonOb;
	
	@Path("/getAllTrainees")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return service.getAllTrainees();
	}

	@Path("/createTrainee")
	@POST
	@Produces({ "application/json" })
	public String addTrainee(String t) {
		return service.createTrainee(t);
	}

	@Path("/deleteTrainee/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") Long id) {
		return service.deleteTrainee(id);
	}
	
	@Path("/getTrainee/{id}")
	@GET
	@Produces({ "application/json" })
	public String getTrainee(@PathParam("id") Long id) {
		return service.getTrainee(id);
	}
	
	@Path("/updateTrainee")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainee(String t) {
		Trainee tObj= jsonOb.getObjectForJSON(t, Trainee.class);
		return service.updateTrainee(tObj);
	}

	public void setService(TraineeService service) {
		this.service = service;
	}

}
