package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.model.Time;

@Controller
@RequestMapping("/time")
public class TimeController {

	@GetMapping("form")
	public String abrirForm(){
		return "time/cadastrar";
	}
	@PostMapping("cadastrar")
	public ModelAndView processaForm(Time time){
		System.out.println(time.getNome());
		ModelAndView retorno = new ModelAndView("time/sucesso");
	retorno.addObject("t",time);
	return retorno;
	}
}