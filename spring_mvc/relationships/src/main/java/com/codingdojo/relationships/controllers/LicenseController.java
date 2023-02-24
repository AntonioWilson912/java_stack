package com.codingdojo.relationships.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.LicenseService;

@Controller
public class LicenseController {
	
	@Autowired
	LicenseService licenseService;
	
	@GetMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		ArrayList<Person> persons = (ArrayList<Person>) licenseService.allPeople();
		model.addAttribute("persons", persons);
		return "/licenses/new.jsp";
	}

	@PostMapping("/licenses")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result.getFieldErrors());
			return "/licenses/new.jsp";
		}
		licenseService.createLicense(license);
		return "redirect:/persons";
	}
}
