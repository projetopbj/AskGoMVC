package br.laab.askgomvc.dao;

import java.util.List;

import br.laab.askgomvc.entities.Enquete;

public interface IEnqueteDAO extends IDAO<Enquete, Long> {

	public List<Enquete> buscar(Enquete filtro);
	
}
