package br.laab.askgo.test;

import java.util.List;

import br.laab.askgo.dao.IUsuarioDAO;
import br.laab.askgo.dao.Imp.UsuarioDAO;
import br.laab.askgo.entities.Enquete;
import br.laab.askgo.entities.Usuario;
import br.laab.askgo.controller.EnqueteController;

public class TesteMain {

	public static void main(String[] args) {

		Usuario user = new Usuario();
		user.setNome("Adilanne");
		user.setEmail("brasil@brasil.br");
		user.setCelular("9999");;
		
		IUsuarioDAO userDao = new UsuarioDAO();
		
		userDao.save(user);

		List<Usuario> listaUsers = userDao.getAll(Usuario.class);

		for (Usuario u : listaUsers) {
			System.out.println(u.getNome());
		}
		
		// Enquete		
		Enquete enq = new Enquete();
		enq.setDescricao("Melhor dia para a reunião?");
		
		EnqueteController enquet = new EnqueteController();
		enquet.cadastrarEnquete(enq, user);
		
		System.out.println(enquet.gerarLink(enq.getId()));		
	}

}