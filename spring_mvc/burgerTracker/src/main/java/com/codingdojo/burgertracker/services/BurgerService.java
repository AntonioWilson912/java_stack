package com.codingdojo.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.burgertracker.models.Burger;
import com.codingdojo.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	private final BurgerRepository burgerRepo;
	
	public BurgerService(BurgerRepository burgerRepo) {
		this.burgerRepo = burgerRepo;
	}
	
	public List<Burger> allBurgers() {
		return burgerRepo.findAll();
	}
	
	public Burger createBurger(Burger burger) {
		return burgerRepo.save(burger);
	}
	
	public Burger findBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepo.findById(id);
		if (optionalBurger != null) {
			return optionalBurger.get();
		}
		
		return null;
	}
	
	public Burger updateBurger(Long id, String burgerName, String restaurantName, Integer rating, String notes) {
		Burger burger = findBurger(id);
		if (burger != null) {
			burger.setBurgerName(burgerName);
			burger.setRestaurantName(restaurantName);
			burger.setRating(rating);
			burger.setNotes(notes);
			burgerRepo.save(burger);
		}
		return burger;
	}
	
	public Burger updateBurger(Burger burger) {
		return burgerRepo.save(burger);
	}
}
