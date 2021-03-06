package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.model.Atleta;

@Controller
@RequestMapping("/atleta")
public class AtletaController {

	@GetMapping("form")
	public String abrirForm(){
		return "atleta/cadastro";
	}
	@PostMapping("cadastrar")
	//PROCESSAR AS INFORMAÇÕES DO FORMULÁRIO
	public ModelAndView processaForm(Atleta atleta){
		System.out.println(atleta.getNome());
		System.out.println(atleta.getPeso());
		System.out.println(atleta.getAltura());
		ModelAndView retorno = new ModelAndView("atleta/lista");
	retorno.addObject("a",atleta);
		return retorno;
	
	}
}
