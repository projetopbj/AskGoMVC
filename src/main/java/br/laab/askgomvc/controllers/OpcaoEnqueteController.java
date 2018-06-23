package br.laab.askgomvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.laab.askgomvc.services.EnqueteService;
import br.laab.askgomvc.services.OpcaoEnqueteService;

@Controller
@RequestMapping(value="opcaoEnquete")
public class OpcaoEnqueteController {

	@Autowired
	private OpcaoEnqueteService OpcaoEnqueteService;
}
