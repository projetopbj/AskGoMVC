package br.laab.askgomvc.dao.Imp;

import org.springframework.stereotype.Repository;

import br.laab.askgomvc.dao.IOpcaoEnqueteDAO;
import br.laab.askgomvc.entities.OpcaoEnquete;

@Repository
public class OpcaoEnqueteDAO extends DAO<OpcaoEnquete, Long> implements IOpcaoEnqueteDAO{

}
