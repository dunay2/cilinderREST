package com.sample.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;  

@Path("/cylinder")

public class CylinderService {
	
	//test entry point
	@GET
	@Path("/")
	public Response sayHello() {
		return Response.ok("Hello World from API REST " +  LocalDateTime.now() , MediaType.APPLICATION_JSON).build();
	}
	
	@GET//shows usage
	@Path("/calculatesurfacevolume")
	@Produces(MediaType.TEXT_XML)
	public String calculateSurfaceVolume() {
		
		return "<xml><CylinderAreaService>\n" + "<help>Usage:\n calculatearea\\radio\\height\n"
				+ "Output: @Produces(\"application/json\")\nRetunrs surface and volume\n</help>"
				+ "\n</CylinderAreaService></xml>";
	}
	

	/*
	 * calculate surface & volume
	 * returns json with cylinder object
	 * http://localhost:8080/RestCalculationSample/services/cylinder/calculatesurfacevolume/6/10
	 * 
	 * */
	@GET
	@Path("/calculatesurfacevolume/{radio}/{height}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cylinder calculateSurface(@PathParam("radio") double radio, @PathParam("height") double height) {

		Cylinder myCylinder = new Cylinder(radio, height); 
				
		return myCylinder;

	}
	
	/* usage
	*http://localhost:8080/RestCalculationSample/services/cylinder/calculatesurfacevolume?radio=1&height=2
	*/
	@GET
	@Path("/calculateparamsurfacevolume")
	public Response getCustomers(
			@QueryParam("radio") String radio, 
			@QueryParam("height") String height
			) {
		
		Cylinder myCylinder = new Cylinder(Double.parseDouble(radio) ,Double.parseDouble (height)); 
		
		String result =myCylinder.toString(); 
			result=	String.format("radio = %s, height = %s , volume = %s , surface = %s", new String[]{radio, height, String.valueOf(myCylinder.getVolume()),String.valueOf(myCylinder.getSurface()) });
		return Response.ok(result).build();
	}
	
}
