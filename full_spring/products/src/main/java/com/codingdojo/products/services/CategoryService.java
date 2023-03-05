package com.codingdojo.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> allCategories() {
		return categoryRepository.findAll();
	}
	
	public Category createCategory(Category c) {
		return categoryRepository.save(c);
	}
	
	public Category findCategory(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		if (category.isPresent()) {
			return category.get();
		}
		
		return null;
	}
	
	public List<Category> allCategoriesForProduct(Product p) {
		return categoryRepository.findAllByProducts(p);
	}
	
	public List<Category> allCategoriesNotForProduct(Product p) {
		return categoryRepository.findByProductsNotContains(p);
	}
	
	public void addProductToCategory(Long categoryId, Product product) {
		Category c = findCategory(categoryId);
		c.getProducts().add(product);
		categoryRepository.save(c);
	}
}
