package br.laab.askgomvc.dao;

import java.util.List;

import br.laab.askgomvc.entities.OpcaoEnquete;

public interface IOpcaoEnqueteDAO extends IDAO<OpcaoEnquete, Long> {

	List<OpcaoEnquete> buscar(OpcaoEnquete filter);

}
