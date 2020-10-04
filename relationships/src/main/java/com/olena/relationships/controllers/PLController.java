package com.olena.relationships.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.olena.relationships.models.License;
import com.olena.relationships.models.Person;
import com.olena.relationships.services.PLService;

@Controller
public class PLController {
	private final PLService pLService;

	public PLController(PLService pLService) {
		super();
		this.pLService = pLService;
	}
	
	@RequestMapping("/persons/new")
	public String NewPerson(@ModelAttribute("person") Person person) {
		return "personPage.jsp";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String CreatePerson(@ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors() ) {
			return "personPage.jsp";
		}
		pLService.createPerson(person);
		return "redirect:/licenses/new";
	}
	@RequestMapping("/licenses/new")
	public String NewLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> unlicensed = pLService.getPeopleWithoutLicense();
		model.addAttribute("persons", unlicensed);
		return "personPage.jsp";
	}
	@RequestMapping(value = "/licenses", method=RequestMethod.POST)
	public String CreateLicense(@ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors())
			return "personPage.jsp";
		pLService.createLicense(license);
		return "redirect:/licenses/{id}";
	}
	@RequestMapping("/licenses/{id}")
	public String ShowPerson(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", pLService.getPerson(id));
		return "licensePage.jsp";
	}
}
