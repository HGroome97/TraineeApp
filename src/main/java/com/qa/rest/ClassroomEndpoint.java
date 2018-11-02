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
import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

@Path("/classroom")
public class ClassroomEndpoint {
	
	@Inject
	private ClassroomService service;

	
	@Inject
	private JSONUtil jsonOb;
	
	@Path("/getAllClassrooms")
	@GET
	@Produces({ "application/json" })
	public String getAllClassrooms() {
		return service.getAllClassrooms();
	}

	@Path("/createClassroom")
	@POST
	@Produces({ "application/json" })
	public String addClassroom(String cr) {
		return service.createClassroom(cr);
	}

	@Path("/deleteClassroom/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroom(@PathParam("id") Long id) {
		return service.deleteClassroom(id);
	}
	
	@Path("/getClassroom/{id}")
	@GET
	@Produces({ "application/json" })
	public String getClassroom(@PathParam("id") Long id) {
		return service.getClassroom(id);
	}
	
	@Path("/updateClassroom")
	@PUT
	@Produces({ "application/json" })
	public String updateClassroom(String cr) {
		Classroom crObj= jsonOb.getObjectForJSON(cr, Classroom.class);
		return service.updateClassroom(crObj);
	}

	public void setService(ClassroomService service) {
		this.service = service;
	}

}
