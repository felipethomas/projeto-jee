package rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/helloworld")
public class HelloWorldResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClichedMessage() {
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Building Web Services with Java EE 8");
		
        return Response.ok(response).build();
    }
	
	@POST
	@Consumes("text/plain")
	public void postClichedMessage(String message) {
	    System.out.println(message);
	}

}
