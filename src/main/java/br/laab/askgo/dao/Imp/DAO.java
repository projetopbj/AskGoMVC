package br.laab.askgo.dao.Imp;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.laab.askgo.dao.IDAO;
import br.laab.askgo.util.Conexao;

public abstract class DAO<T, I extends Serializable> implements IDAO<T, I> {

	private Conexao conexao;

	@Override
	public T save(T entity) {

		T saved = null;

		getEntityManager().getTransaction().begin();
		saved = getEntityManager().merge(entity);
		getEntityManager().getTransaction().commit();

		return saved;
	}

	@Override
	public void remove(T entity) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(entity);
		getEntityManager().getTransaction().commit();

	}

	@Override
	public T getById(Class<T> classe, I pk) {

		try {
			return getEntityManager().find(classe, pk);
		} catch (NoResultException e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> classe) {

		return getEntityManager().createQuery("select o from " + classe.getSimpleName() + " o").getResultList();
	}

	@Override
	public EntityManager getEntityManager() {

		if (conexao == null) {
			conexao = new Conexao();
		}
		return conexao.getEntityManager();
	}

}
