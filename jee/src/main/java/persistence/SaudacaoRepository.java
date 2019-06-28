package persistence;

import java.util.List;

import model.Saudacao;

public interface SaudacaoRepository {
	
	Saudacao findById(Long id);
	
	List<Saudacao> findAll();
	
	void persist(Saudacao saudacao);
	
	void merge(Saudacao saudacao);
	
	void remove(Long id);

}
