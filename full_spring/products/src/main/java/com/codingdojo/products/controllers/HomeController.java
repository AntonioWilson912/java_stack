package com.codingdojo.products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.services.CategoryService;
import com.codingdojo.products.services.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;

	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("products", productService.allProducts());
		model.addAttribute("categories", categoryService.allCategories());
		
		return "index.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String createProduct(@ModelAttribute("product") Product product) {
		productService.createProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String createCategory(@ModelAttribute("category") Category category) {
		categoryService.createCategory(category);
		return "redirect:/";
	}
	
	@GetMapping("/products/{productId}")
	public String showProduct(@PathVariable("productId") Long productId, Model model) {
		model.addAttribute("product", productService.findProduct(productId));
		return "showProduct.jsp";
	}
	
	@GetMapping("/categories/{categoryId}")
	public String showCategory(@PathVariable("categoryId") Long categoryId) {
		return "showCategory.jsp";
	}
}
