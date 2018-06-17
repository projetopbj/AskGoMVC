package br.laab.askgomvc.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.laab.askgomvc.services.EnqueteService;
import br.laab.askgomvc.entities.Enquete;

@Controller
@Transactional
@RequestMapping("/enquete")
public class EnqueteController {

	@Autowired
	private EnqueteService enqueteService;

	//List
	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		List<Enquete> enquetes = enqueteService.listar();
		modelMap.addAttribute("enquetes", enquetes);
		return "enquete/index";
	}

	//Create
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		Enquete enquete = new Enquete();
		modelMap.addAttribute("aluno", enquete);
		return "enquete/form";
	}

	//Post
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String save(@ModelAttribute("aluno") Enquete enquete) {
		
		if (enquete.hasValidId()) {
			enqueteService.atualizar(enquete);
		}
		else {
			enqueteService.inserir(enquete);
		}
		
		return "redirect:/index";
	}
	
	//Update
	@RequestMapping(method=RequestMethod.GET, value="{id}/form")
	public String updateForm(@PathVariable Long id, ModelMap map){
		Enquete enquete = enqueteService.buscarPorId(id);
		map.addAttribute("enquete", enquete);
		return "enquete/form";
	}
	
	//Delete
	@Transactional
	@RequestMapping(value = "{id}/excluir", method = RequestMethod.DELETE)
	public String remove(@PathVariable("id") Long id) {
		Enquete enquete = enqueteService.buscarPorId(id);
		enqueteService.remover(enquete);
		return "redirect:/index";
	}

}
