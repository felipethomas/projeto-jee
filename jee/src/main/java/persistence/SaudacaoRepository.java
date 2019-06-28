package persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import model.Saudacao;

@Transactional(rollbackOn = { Exception.class })
public class SaudacaoRepository implements Repository {

	@Inject
	private EntityManager saudacaoEntityManager;

	public Saudacao findById(Long id) {
		return saudacaoEntityManager.find(Saudacao.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Saudacao> findAll() {
		return saudacaoEntityManager.createQuery("FROM Saudacao ORDER BY id").getResultList();
	}

	public void persist(Saudacao saudacao) {
		saudacaoEntityManager.persist(saudacao);
	}

	public void merge(Saudacao saudacao) {
		saudacaoEntityManager.merge(saudacao);
	}

	public void remove(Long id) {
		Saudacao saudacao = saudacaoEntityManager.find(Saudacao.class, id);
		saudacaoEntityManager.remove(saudacao);
	}

}
