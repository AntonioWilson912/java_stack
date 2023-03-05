package com.codingdojo.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.products.models.Category;
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
}
