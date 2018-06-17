package br.laab.askgomvc.entities;

public abstract class Entities {
	
	public abstract void setId(Long id);
	public abstract Long getId();
	
	public boolean hasValidId(){
		return getId() != null && getId() != 0;
	}

}
