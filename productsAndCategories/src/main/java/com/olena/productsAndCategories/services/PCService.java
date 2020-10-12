package com.olena.productsAndCategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olena.productsAndCategories.models.Category;
import com.olena.productsAndCategories.models.Product;
import com.olena.productsAndCategories.repositories.CategoryRepository;
import com.olena.productsAndCategories.repositories.ProductRepository;

@Service
public class PCService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	public PCService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public List<Category> getCategories(){
		return categoryRepository.findAll();
	}
	
	public Product findById(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public Category findByIdCat(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}
	
	
}
