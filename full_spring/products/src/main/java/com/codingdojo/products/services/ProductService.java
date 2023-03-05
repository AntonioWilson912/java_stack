package com.codingdojo.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> allProducts() {
		return productRepository.findAll();
	}
	
	public Product createProduct(Product p) {
		return productRepository.save(p);
	}
	
	public Product findProduct(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			return product.get();
		}
		return null;
	}
	
	public List<Product> allProductsNotInCategory(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}
	
	public void addCategoryToProduct(Long productId, Category category) {
		Product p = findProduct(productId);
		p.getCategories().add(category);
		productRepository.save(p);
	}

}
