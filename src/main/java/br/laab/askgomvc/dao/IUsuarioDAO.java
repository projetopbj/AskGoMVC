package br.laab.askgomvc.dao;

import java.util.List;

import br.laab.askgomvc.entities.Usuario;

public interface IUsuarioDAO extends IDAO<Usuario, Long> {
	 
public Usuario logar(String email, String senha);

public List<Usuario> buscar(Usuario filtro);

}
