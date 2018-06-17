package br.laab.askgomvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.laab.askgomvc.dao.IUsuarioDAO;
import br.laab.askgomvc.entities.Usuario;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioService {

	@Autowired
	private IUsuarioDAO usuarioDAO;

	public Usuario logar(String email, String senha) {
		return usuarioDAO.logar(email, senha);
	}

	public void inserir(Usuario user) {
		usuarioDAO.insert(user);
	}

	public void atualizar(Usuario user) {
		usuarioDAO.update(user);
	}

	public List<Usuario> listar() {
		return usuarioDAO.getAll(Usuario.class);
	}

	public void remover(Usuario user) {
		usuarioDAO.remove(user);
	}

	public Usuario buscarPorId(Long id) {
		return usuarioDAO.getById(Usuario.class, id);
	}
	public List<Usuario> buscarFiltro(Usuario filter) {
		return usuarioDAO.buscar(filter);
	}
	
}
