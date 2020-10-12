package com.olena.productsAndCategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.olena.productsAndCategories.models.Category;
import com.olena.productsAndCategories.models.Product;
import com.olena.productsAndCategories.services.PCService;

@Controller
public class PCController {
	@Autowired
	private final PCService pCService;
	
	public PCController(PCService pCService) {
		this.pCService = pCService;
	}
	
	@GetMapping("/")
	public String getHome() {
		return "redirect:/home";
	}
	@GetMapping("/home")
	public String getHome(Model model) {
		model.addAttribute("products",pCService.getProducts());
		model.addAttribute("categories", pCService.getCategories());
		return "index.jsp";
	}
	
	@GetMapping("/products/new")
	public String getAll(@ModelAttribute("product") Product product) {
		return "product.jsp";
	}
	
	@PostMapping("/products/new")
	public String saveProduct(@ModelAttribute("product") Product product) {
		pCService.saveProduct(product);
		return "redirect:/home";
	}
	
	
	@GetMapping("/categories/new")
	public String getCategory(@ModelAttribute("category") Category category) {
		return "category.jsp";
	}
	
	@PostMapping("/categories/new")
	public String saveCategory(@ModelAttribute("category") Category category) {
		pCService.saveCategory(category);
		return "redirect:/home";
	}
	
	@GetMapping("/products/{id}")
	public String GetShowPro(
			Model model,
			@PathVariable("id") Long id, 
			Product product)
	{
		model.addAttribute("product", pCService.findById(id));
		model.addAttribute("categories", pCService.getCategories());
		return "prodDesc.jsp";
	}
	
	
	@PostMapping("/products/{id}")
	public String postShowPro(
			Product product, 
			@PathVariable("id") Long id)
	{
		Category category = product.getCategories().get(0);
		
		Product productUpdate=pCService.findById(id);
		if(!productUpdate.getCategories().contains(category)) {
		productUpdate.getCategories().add(category);
		pCService.saveProduct(productUpdate);
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/categories/{id}")
	public String GetShowPro(
			Model model,
			@PathVariable("id") Long id, 
			Category category)
	{
		model.addAttribute("products", pCService.getProducts());
		model.addAttribute("category", pCService.findByIdCat(id));
		return "catDesc.jsp";
	}
	
	
	@PostMapping("/categories/{id}")
	public String postShowPro1(
			Category category, 
			@PathVariable("id") Long id)
	{
		Product product =category.getProducts().get(0);
		
		Category categoryUpdate=pCService.findByIdCat(id);
		if(!categoryUpdate.getProducts().contains(product)) {
		categoryUpdate.getProducts().add(product);
		pCService.saveCategory(categoryUpdate);
		}
		
		return "redirect:/";
	}
	
}
