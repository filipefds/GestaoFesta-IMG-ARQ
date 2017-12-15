package com.algaworks.festa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.repository.Convidados;
import com.algaworks.festa.repository.Festas;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {

	@Autowired
	private Convidados convidados;
	@Autowired
	private Festas festas;

	@GetMapping()
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaConvidados");
		List <Convidado> lista = convidados.findAll();
		mv.addObject("convidados",lista);
		mv.addObject("todasFestas", festas.findAll());
		mv.addObject(new Convidado());
		return mv;
	}

	@PostMapping()
	public String salvar(Convidado c) {
		convidados.save(c);
		return "redirect:/convidados";

	}

	//URL de chamada http://.../excluir/1234				
	@RequestMapping(value = "/excluir/{id}")
	public String excluirConvidadoByPathVariable(@PathVariable Long id, RedirectAttributes attributes)	{
		this.convidados.delete(id);
		attributes.addFlashAttribute("mensagem", "Convidado excluído com sucesso!");
		return "redirect:/convidados";
	}

	//URL de chamada http://.../alterar/1234
	@RequestMapping(value = "/alterar/{id}")
	public ModelAndView alterar(@PathVariable Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("ListaConvidados");
		List <Convidado> lista = convidados.findAll();
		mv.addObject("convidados",lista);
		Convidado convidado = convidados.findOne(id);
		mv.addObject(convidado);
		return mv;
	}

}
