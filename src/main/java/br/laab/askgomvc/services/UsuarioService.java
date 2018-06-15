package br.laab.askgomvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.laab.askgomvc.entities.Usuario;
import br.laab.askgomvc.dao.IUsuarioDAO;


@Service
@Transactional
public class UsuarioService {

	@Autowired
	private IUsuarioDAO usuarioDAO;

	public Usuario logar(String email, String senha) {
		return usuarioDAO.logar(email, senha);
	}
	
}
