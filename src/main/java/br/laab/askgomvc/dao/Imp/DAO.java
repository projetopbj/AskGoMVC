package br.laab.askgomvc.dao.Imp;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.laab.askgomvc.dao.IDAO;

public abstract class DAO<T, I extends Serializable> implements IDAO<T, I> {

	@PersistenceContext
	protected EntityManager manager;
	
	public void insert(T entity) {
		manager.persist(entity);
	}
	
	public void update(T entity) {
		manager.merge(entity);
	}

	public void remove(T entity) {
		manager.remove(manager.contains(entity) ? entity : manager.merge(entity));
	}

	public T getById(Class<T> classe, I pk) {
		try {
			return manager.find(classe, pk);
		} catch (NoResultException e) {
			return null;
		}

	}

	public List<T> getAll(Class<T> classe) {
		return manager.createQuery("select o from " + classe.getSimpleName() + " o").getResultList();
	}
}
