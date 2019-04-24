package com.angelogalvao.samples.swagger.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.angelogalvao.samples.swagger.resource.model.Test;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * 
 * Simple REST resource
 * 
 * @author <a href="mailto:angelogalvao@gmail.com">Ângelo Galvão</a>
 *
 */
@Path("/test")
@Api(value = "/test", description = "Test Resource")
public class TestResource {

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Create the Test entity")
	public Test createTest(@ApiParam(value = "Test object that will be created", required = true) Test test) {
		
		// it acctually do nothing
		return new Test();
	}
}
