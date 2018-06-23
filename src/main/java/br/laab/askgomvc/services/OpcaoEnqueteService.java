package br.laab.askgomvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.laab.askgomvc.dao.IOpcaoEnqueteDAO;
import br.laab.askgomvc.entities.OpcaoEnquete;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OpcaoEnqueteService {

	@Autowired
	private IOpcaoEnqueteDAO opcaoEnqueteDAO;
	
	public void inserir(OpcaoEnquete enquete) {
		opcaoEnqueteDAO.insert(enquete);
	}

	public void atualizar(OpcaoEnquete enquete) {
		opcaoEnqueteDAO.update(enquete);
	}

	public List<OpcaoEnquete> listar() {
		return opcaoEnqueteDAO.getAll(OpcaoEnquete.class);
	}

	public void remover(OpcaoEnquete enquete) {
		opcaoEnqueteDAO.remove(enquete);
	}

	public OpcaoEnquete buscarPorId(Long id) {
		return opcaoEnqueteDAO.getById(OpcaoEnquete.class, id);
	}
	
	public List<OpcaoEnquete> buscarFiltro(OpcaoEnquete filter) {
		return opcaoEnqueteDAO.buscar(filter);
	}

}
