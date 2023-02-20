package com.codingdojo.burgertracker.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.burgertracker.models.Burger;
import com.codingdojo.burgertracker.services.BurgerService;

@Controller
public class BurgerController {
	
	@Autowired
	BurgerService burgerService;

	@GetMapping("")
	public String index(@ModelAttribute("burger") Burger burger, Model model) {
		ArrayList<Burger> burgers = (ArrayList<Burger>) burgerService.allBurgers();
		model.addAttribute("burgers", burgers);
		return "index.jsp";
	}
	
	@PostMapping("")
	public String createBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
		burgerService.createBurger(burger);
		return "redirect:/";
	}
	
	@GetMapping("/burgers/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Burger burger = burgerService.findBurger(id);
		model.addAttribute("burger", burger);
		return "edit.jsp";
	}
	
	@PutMapping("/burgers/{id}")
	public String updateBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		burgerService.updateBurger(burger);
		return "redirect:/";
	}
}
