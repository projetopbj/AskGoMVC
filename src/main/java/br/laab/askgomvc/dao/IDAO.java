package br.laab.askgomvc.dao;

import java.io.Serializable;
import java.util.List;

public interface IDAO<T, I extends Serializable> {
	
	public void insert(T entity);

	public void update(T entity);

	public void remove(T entity);

	public T getById(Class<T> classe, I pk);

	public List<T> getAll(Class<T> classe);
}