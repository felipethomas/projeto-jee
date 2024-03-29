package rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Cidade;
import persistence.CidadeRepository;

@Path("/cidades")
public class CidadeResource {
	
	@Inject
	private CidadeRepository cidadeRepository;
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCidadeById(@PathParam("id") Long id) {
		Cidade cidade = cidadeRepository.findById(id);
		return Response.ok(cidade).build();
	}

}
