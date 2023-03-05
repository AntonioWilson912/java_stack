package com.codingdojo.products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		Product product = productService.findProduct(productId);
		model.addAttribute("product", product);
		model.addAttribute("notInCategories", categoryService.allCategoriesNotForProduct(product));
		return "showProduct.jsp";
	}
	
	@PutMapping("/products/{productId}")
	public String addCategoryToProduct(@PathVariable("productId") Long productId, @RequestParam("categoryId") Long categoryId) {
		productService.addCategoryToProduct(productId, categoryService.findCategory(categoryId));
		return "redirect:/";
	}
	
	@GetMapping("/categories/{categoryId}")
	public String showCategory(@PathVariable("categoryId") Long categoryId, Model model) {
		Category category = categoryService.findCategory(categoryId);
		model.addAttribute("category", category);
		model.addAttribute("productsNotIn", productService.allProductsNotInCategory(category));
		return "showCategory.jsp";
	}
	
	@PutMapping("/categories/{categoryId}")
	public String addProductToCategory(@PathVariable("categoryId") Long categoryId, @RequestParam("productId") Long productId) {
		categoryService.addProductToCategory(categoryId, productService.findProduct(productId));
		return "redirect:/";
	}
}
