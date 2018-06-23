package br.laab.askgomvc.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.laab.askgomvc.entities.Usuario;
import br.laab.askgomvc.services.UsuarioService;


@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value={"/", "loginForm"}, method=RequestMethod.GET)
	public String form(ModelMap map){
		map.addAttribute("usuario", new Usuario());
		return "login/login";
	}
	
	@RequestMapping(value="logar", method=RequestMethod.POST)
	public String logar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, HttpSession sessao, ModelMap map){
		if(result.hasErrors() ){
			map.addAttribute("usuario", usuario);
			return  "login/login";
		}
		Usuario usuarioBD = usuarioService.logar(usuario.getEmail(), usuario.getSenha()); 
		if(usuarioBD == null){
			usuario.setSenha("");
			map.addAttribute("usuario", usuario);
			return  "login/login";
		}
		sessao.setAttribute("usuario", usuarioBD);
		return "redirect:/enquete/listar";
	}
	
	
}
