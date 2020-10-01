package br.com.kiev.maonafrota.infrastructure.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.kiev.maonafrota.application.CondutorService;
import br.com.kiev.maonafrota.application.ValidationException;
import br.com.kiev.maonafrota.application.VeiculoService;
import br.com.kiev.maonafrota.domain.condutor.Condutor;
import br.com.kiev.maonafrota.domain.veiculo.Veiculo;

@Controller
@RequestMapping(path = "/adm")
public class AdmController {

	@Autowired
	private CondutorService condutorService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping("/condutor/new")
	public String newCondutor(Model model) {
		
		model.addAttribute("condutor", new Condutor());
		ControllerHelper.setEditMode(model, false);
		
		return "condutor-cadastro";
	}
	
	@PostMapping(path = "/condutor/save")
	public String saveCondutor(
			@ModelAttribute("condutor") @Valid Condutor condutor,
			Errors errors,
			Model model) {

		if (!errors.hasErrors()) {
			try {
				condutorService.saveCondutor(condutor);
				model.addAttribute("msg", "Condutor gravado com sucesso!");
			} catch (ValidationException e) {
				errors.rejectValue("matricula", null, e.getMessage());
			}
		}
		
		ControllerHelper.setEditMode(model, false);
		return "condutor-cadastro";
	}
	
	@GetMapping("/veiculo/new")
	public String newVeiculo(Model model) {
		
		model.addAttribute("veiculo", new Veiculo());
		ControllerHelper.setEditMode(model, false);
		
		return "veiculo-cadastro";
	}
	
	@PostMapping(path = "/veiculo/save")
	public String saveVeiculo(
			@ModelAttribute("veiculo") @Valid Veiculo veiculo,
			Errors errors,
			Model model) {

		if (!errors.hasErrors()) {
			veiculoService.saveVeiculo(veiculo);
			model.addAttribute("msg", "Veículo gravado com sucesso!");
		}
		
		ControllerHelper.setEditMode(model, false);
		return "veiculo-cadastro";
	}
}
