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

import br.laab.askgomvc.entities.Usuario;
import br.laab.askgomvc.services.UsuarioService;

@Controller
@RequestMapping(value="usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map){
		List<Usuario> users = usuarioService.listar();
		map.addAttribute("usuarios", users);
		map.addAttribute("filtro", new Usuario());
		return "/usuario/listar";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Usuario filtro, ModelMap map){
		
		List<Usuario> users = usuarioService.buscarFiltro(filtro);
		map.addAttribute("usuarios", users);
		map.addAttribute("filtro", filtro);
		return "/usuario/listar";
	}
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map){
		Usuario user = new Usuario();
		map.addAttribute("usuario", user);
		
		return "usuario/form";
	}
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("usuario") @Valid Usuario usuario,BindingResult result, ModelMap map ){
		
		if(result.hasErrors()){
			map.addAttribute("usuario", usuario);
			return "usuario/form";
			
		}
		if(usuario.getId() != null){
			usuarioService.atualizar(usuario);
		}
		else{
			usuarioService.inserir(usuario);
		}
		
		return "redirect:/usuario/listar";
	}

	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String remove(@PathVariable Long id){
		usuarioService.remover(new Usuario(id));
		return "redirect:/usuario/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/form")
	public String updateForm(@PathVariable Long id, ModelMap map){
		Usuario usuario = usuarioService.buscarPorId(id);
		map.addAttribute("usuario", usuario);
		return "usuario/form";
	}
}
