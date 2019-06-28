package rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Saudacao;
import persistence.Repository;

@Path("/saudacoes")
public class SaudacaoResource {

	@Inject
	private Repository saudacaoRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSaudacoes() {
		List<Saudacao> saudacoes = saudacaoRepository.findAll();
		return Response.ok(saudacoes).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSaudacaoById(@PathParam("id") Long id) {
		Saudacao saudacao = saudacaoRepository.findById(id);
		return Response.ok(saudacao).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarSaudacao(Saudacao saudacao) {
		saudacaoRepository.persist(saudacao);
		return Response.ok(saudacao).build();
	}
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removerSaudacao(@PathParam("id") Long id) {
		saudacaoRepository.remove(id);
		return Response.ok().build();
	}
}
