package br.laab.askgo.controller;

import java.util.ArrayList;

import br.laab.askgo.dao.IEnqueteDAO;
import br.laab.askgo.dao.Imp.EnqueteDAO;
import br.laab.askgo.entities.Enquete;
import br.laab.askgo.entities.Usuario;

public class EnqueteController {
	
	public boolean cadastrarEnquete(Enquete enq, Usuario user) {		
		IEnqueteDAO enqDao = new EnqueteDAO();			
		enqDao.save(enq);
			
		return true;
		
	}
	
	public String gerarLink(Long id) {
		return "www.linkGerado.com.br";
	}

}
