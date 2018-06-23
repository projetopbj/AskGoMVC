package br.laab.askgomvc.dao.Imp;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.laab.askgomvc.dao.IEnqueteDAO;
import br.laab.askgomvc.entities.Enquete;

@Repository
public class EnqueteDAO extends DAO<Enquete, Long> implements IEnqueteDAO{

	public List<Enquete> buscar(Enquete filtro){
		String str = "select c from Enquete c where upper(titulo) like upper(:titulo) and upper(descricao) liker upper(:descricao)";
		if(filtro.getTitulo() == null){
			filtro.setTitulo("");
		}
		Query query=manager.createQuery(str);   
		
		query.setParameter("titulo", "%"+filtro.getTitulo()+"%");
		query.setParameter("descricao", "%"+filtro.getDescricao()+"%");
		
		return query.getResultList();
	}
	
}
