package jersey.rest.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jersey.rest.model.Car;
import jersey.rest.model.ErrorMessage;

@Path("cars")
public class CarResource {

	
	
	
	
	private static Map<Integer, Car> cars;

	public CarResource() {
		if (cars == null) {
			cars = new HashMap<Integer, Car>();
			
			Car car = new Car();
			car.setRenavam(187321683);
			car.setBrand("Ford");
			car.setModel("Fiest");
			car.setPrice(23000);
			car.setYear(2013);
			post(car);
		}			
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(){
		return Response.status(200)
				.entity(new ArrayList<Car>(cars.values()))
				.build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id){
		if (cars.containsKey(id)) {
			return Response.status(200)
						.entity(cars.get(id))
						.build();
		} else  {
			return Response.status(400)
					.entity(new ErrorMessage("Entity Not Found"))
					.build();
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(Car car) {
		if (cars.containsKey(car.getRenavam()))
		{
			return Response.status(400)
					.entity(new ErrorMessage("Entity Already Exists"))
					.build();
		}

		cars.put(car.getRenavam(), car);
		return Response.status(200).build();
	}

	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response put(@PathParam("id") int id, Car car) {
		if (!cars.containsKey(id)) {
			return Response.status(400)
			.entity(new ErrorMessage("Entity Not Found"))
			.build();
		}
			
		cars.put(car.getRenavam(), car);		
		return Response.status(200).build();
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		if (!cars.containsKey(id)) {
			return Response.status(400)
			.entity(new ErrorMessage("Entity Not Found"))
			.build();
		}

		cars.remove(id);
		return Response.status(200).build();
	}

}
