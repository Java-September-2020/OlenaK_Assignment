package com.olena.dojoAndNinjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.olena.dojoAndNinjas.models.Dojo;
import com.olena.dojoAndNinjas.services.DNService;

@Controller
public class DojoController {
	private final DNService dNService;
	public DojoController(DNService dNService) {
		this.dNService = dNService;
	}
	@RequestMapping("/dojos")
	public String Index(Model model) {
		model.addAttribute("dojos", dNService.allDojos());
		return "/dojos/index.jsp";
	}
	@RequestMapping("/dojos/{id}")
	public String Show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", this.dNService.findDojo(id));
		return "/dojos/show.jsp";
	}
	@RequestMapping("/dojos/new")
	public String New(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/new.jsp";
	}
	@RequestMapping(value="/dojos", method=RequestMethod.POST)
	public String Create(@ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors())
			return "/dojos/new.jsp";
		this.dNService.createDojo(dojo);
		return "redirect:/dojos";
	}
}
