package com.codingdojo.helloworld.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FormController {

	@RequestMapping("/form")
	public String formPage() {
		return "formDemo.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
			@RequestParam(value="email") String email,
			@RequestParam(value="password") String password,
			HttpSession session,
			RedirectAttributes redirectAttributes
			) {
		
		int numErrors = 0;
		if (email == null || email.length() == 0) {
			redirectAttributes.addFlashAttribute("emailError", "Missing email!");
			numErrors++;
		}
		if (password == null || password.length() < 8) {
			redirectAttributes.addFlashAttribute("passwordError", "Password must be at least 8 characters long!");
			numErrors++;
		}
		
		if (numErrors > 0) {
			return "redirect:/form";
		}
		
		if (session.getAttribute("emailError") != null) {
			session.removeAttribute("emailError");
		}
		if (session.getAttribute("passwordError") != null) {
			session.removeAttribute("passwordError");
		}
		session.setAttribute("email", email);
		return "redirect:/results";
	}
	
	@RequestMapping("/results")
	public String results() {
		return "results.jsp";
	}
	
}
