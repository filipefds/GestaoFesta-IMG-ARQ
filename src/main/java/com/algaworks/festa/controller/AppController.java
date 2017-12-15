package com.algaworks.festa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index(Model model) {
		return "index"; 
	}
	
	@RequestMapping(value = {"/trocasenha"}, method = RequestMethod.GET)
	public String trocasenha(Model model) {
		return "trocasenha"; 
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
		ModelAndView model = new ModelAndView("403");
		model.addObject("msg","Você não tem acesso a está página!");
		return model;
	}
}
