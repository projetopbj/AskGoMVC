package br.laab.askgomvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="index")
public class IndexController {
	@RequestMapping(value={"/", "index"}, method=RequestMethod.GET)
	public String list(ModelMap map){
		return "index/index";
	}
	
}
