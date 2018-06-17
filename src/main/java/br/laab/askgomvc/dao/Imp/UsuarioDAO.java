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
	
	public List<Usuario> buscar(Usuario filtro){
		String str = "select c from Usuario c where upper(nome) like upper(:nome)";
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
		if(filtro.getEmail() != null){
			str+=" and c.email = :email";
		}
		Query query=manager.createQuery(str);   
		
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		
		if(filtro.getEmail() != null){
			query.setParameter("email", filtro.getEmail());
		}
		return query.getResultList();
	}
}