package br.laab.askgomvc.dao.Imp;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.laab.askgomvc.dao.IOpcaoEnqueteDAO;
import br.laab.askgomvc.entities.OpcaoEnquete;

@Repository
public class OpcaoEnqueteDAO extends DAO<OpcaoEnquete, Long> implements IOpcaoEnqueteDAO{
	
	public List<OpcaoEnquete> buscar(OpcaoEnquete filtro){
		String str = "select c from OpcaoEnquete c where upper(descricao) like upper(:descricao)";
		if(filtro.getDescricao() == null){
			filtro.setDescricao("");
		}
		Query query=manager.createQuery(str);   
		
		query.setParameter("descricao", "%"+filtro.getDescricao()+"%");
		
		return query.getResultList();
	}

}
