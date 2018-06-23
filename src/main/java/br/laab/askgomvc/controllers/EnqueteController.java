package br.laab.askgomvc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.laab.askgomvc.entities.Enquete;
import br.laab.askgomvc.entities.OpcaoEnquete;
import br.laab.askgomvc.entities.Usuario;
import br.laab.askgomvc.services.EnqueteService;
import br.laab.askgomvc.services.OpcaoEnqueteService;
import br.laab.askgomvc.services.UsuarioService;

@Controller
@RequestMapping(value="enquete")
public class EnqueteController {

	@Autowired
	private EnqueteService enqueteService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private OpcaoEnqueteService opcaoEnqueteService;
	
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map){
		List<Enquete> enquetes = enqueteService.listar();
		map.addAttribute("enquetes", enquetes);
		map.addAttribute("filtro", new Enquete());
		return "/enquete/listar";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Enquete filtro, ModelMap map){
		
		List<Enquete> enquetes = enqueteService.buscarFiltro(filtro);
		map.addAttribute("enquetes", enquetes);
		map.addAttribute("filtro", filtro);
		return "/enquete/listar";
	}
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map){
		Enquete enquete = new Enquete();
		map.addAttribute("enquete", enquete);
		
		return "enquete/form";
	}
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("enquete") Enquete enquete, BindingResult result, ModelMap map, HttpServletRequest request ){
		
		/*if(result.hasErrors()){
			map.addAttribute("enquete", enquete);
			return "enquete/form";
			@ModelAttribute("opcaoEnquete") OpcaoEnquete opcaoEnquete,
			
		}*/
		if(enquete.getId() != null){
			enqueteService.atualizar(enquete);
		}
		else{
			enquete.setEstado(true);
			
			try {
				
				Usuario user = (Usuario)request.getSession().getAttribute("usuario");
				List<Usuario> users = new ArrayList<>();
				//users.add(user);
				if(user.getId() != null) 
				{
					enquete.setCriadorEnquete(user);
					//enquete.setEnqueteUsuarios(users);
					
				}
			}catch (Exception e) {
				return "redirect:/enquete/listar";
			}

			/*
			opcaoEnqueteService.inserir(opcaoEnquete);
			*/
			enqueteService.inserir(enquete);
		}
		
		return "redirect:/enquete/listar";
	}

	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String remove(@PathVariable Long id){
		enqueteService.remover(new Enquete(id));
		return "redirect:/enquete/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/form")
	public String updateForm(@PathVariable Long id, ModelMap map){
		Enquete enquete = enqueteService.buscarPorId(id);
		map.addAttribute("enquete", enquete);
		return "enquete/form";
	}
}
