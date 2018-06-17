package br.laab.askgomvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.laab.askgomvc.dao.Imp.EnqueteDAO;
import br.laab.askgomvc.entities.Enquete;


public class EnqueteService {
	
	@Autowired
	private EnqueteDAO enqueteDAO;

	public void inserir(Enquete enquete) {
		enqueteDAO.insert(enquete);
	}

	public void atualizar(Enquete enquete) {
		enqueteDAO.update(enquete);
	}

	public List<Enquete> listar() {
		return enqueteDAO.getAll(Enquete.class);
	}

	public void remover(Enquete enquete) {
		enqueteDAO.remove(enquete);
	}

	public Enquete buscarPorId(Long id) {
		return enqueteDAO.getById(Enquete.class, id);
	}

}
