package com.olena.dojoAndNinjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.olena.dojoAndNinjas.models.Ninja;
import com.olena.dojoAndNinjas.services.DNService;

@Controller
public class NinjaController {
	private DNService dNService;
	public NinjaController(DNService dNService) {
		this.dNService = dNService;
	}
	@RequestMapping("/ninjas")
	public String Index(Model model) {
		model.addAttribute("ninjas", this.dNService.allNinjas());
		return "/ninjas/index.jsp";
	}
	
	@RequestMapping("/ninjas/new")
	public String New(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", this.dNService.allDojos());
		return "/ninjas/new.jsp";
	}
	@RequestMapping(value="/ninjas", method=RequestMethod.POST)
	public String Create(@ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", this.dNService.allDojos());
			return "/ninjas/new.jsp";
		}
		this.dNService.createNinja(ninja);
		return "redirect:/ninjas";
	}
}
