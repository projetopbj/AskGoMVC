package br.laab.askgomvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.laab.askgomvc.entities.Enquete;
import br.laab.askgomvc.services.EnqueteService;

@Controller
@RequestMapping(value="enquete")
public class EnqueteController {

	@Autowired
	private EnqueteService enqueteService;
	
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
	public String save(@ModelAttribute("enquete") @Valid Enquete enquete,BindingResult result, ModelMap map ){
		
		if(result.hasErrors()){
			map.addAttribute("enquete", enquete);
			return "enquete/form";
			
		}
		if(enquete.getId() != null){
			enqueteService.atualizar(enquete);
		}
		else{
			enquete.setEstado(true);
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
