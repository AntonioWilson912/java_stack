package com.codingdojo.relationships.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	PersonService personService;

	@GetMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "/persons/new.jsp";
	}
	
	@PostMapping("/persons")
	public String createPerson(@ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "/persons/new.jsp";
		}
		personService.createPerson(person);
		return "redirect:/";
	}
	
	@GetMapping("/persons/{id}")
	public String showPerson(@PathVariable("id") Long id, Model model) {
		Person person = personService.findPerson(id);
		model.addAttribute("person", person);
		return "/persons/show.jsp";
	}
	
	
}
