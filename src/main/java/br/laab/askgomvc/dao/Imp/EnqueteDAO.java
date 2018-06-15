package br.laab.askgomvc.dao.Imp;

import org.springframework.stereotype.Repository;
import br.laab.askgomvc.dao.IEnqueteDAO;
import br.laab.askgomvc.entities.Enquete;

@Repository
public class EnqueteDAO extends DAO<Enquete, Long> implements IEnqueteDAO{

}
