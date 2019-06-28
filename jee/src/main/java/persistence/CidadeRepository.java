package persistence;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import model.Cidade;

@Transactional(rollbackOn = { Exception.class })
public class CidadeRepository {
	
	@Inject
	private EntityManager entityManagerApp;

	public Cidade findById(Long id) {
		return entityManagerApp.find(Cidade.class, id);
	}

}
