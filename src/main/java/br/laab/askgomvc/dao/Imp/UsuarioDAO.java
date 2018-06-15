package br.laab.askgomvc.dao.Imp;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.laab.askgomvc.dao.IUsuarioDAO;
import br.laab.askgomvc.entities.Usuario;

@Repository
public class UsuarioDAO extends DAO<Usuario, Long> implements IUsuarioDAO {

	@Override
	public Usuario logar(String email, String senha){
		
		Query query = manager.createQuery("select u from Usuario u where u.email = :email and u.senha = :senha");
		query.setParameter("email", email);
		query.setParameter("senha", senha);
		List<Usuario> usuarios =  query.getResultList();
		
		return usuarios.isEmpty() ? null : usuarios.get(0);
	}
	 
}