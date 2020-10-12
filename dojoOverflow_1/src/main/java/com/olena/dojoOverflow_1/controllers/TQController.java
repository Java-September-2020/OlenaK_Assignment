package com.olena.dojoOverflow_1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.olena.dojoOverflow_1.models.Question;
import com.olena.dojoOverflow_1.services.TQService;

@Controller
public class TQController {
	private final TQService tQService;
	public TQController(TQService tQService) {
		this.tQService = tQService;
	}
	
	@GetMapping("/")
	public String Redirect() {
		return "redirect:/questions";
	}
	
	@GetMapping("/questions") 
	public String Index(Model model){
		model.addAttribute("questions", tQService.allQuestions());
		return "index.jsp";		
	}
	@GetMapping("/questions/new")
	public String NewQuestion(@ModelAttribute("question") Question question) {
		return "new.jsp";
	}
	
	@PostMapping("/question")
	public String CreateQuestion(@ModelAttribute("question") Question question,	BindingResult result) {
		if(result.hasErrors())
			return "new.jsp";
		tQService.createQuestion(question);
		return "redirect:/";
	}
}
