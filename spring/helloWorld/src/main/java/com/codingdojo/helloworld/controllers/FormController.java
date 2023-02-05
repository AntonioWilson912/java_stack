package com.codingdojo.helloworld.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
			HttpSession session
			) {
		
		int numErrors = 0;
		if (email == null || email.length() == 0) {
			session.setAttribute("emailError", "Missing email!");
			numErrors++;
		}
		else {
			if (session.getAttribute("emailError") != null) {
				session.removeAttribute("emailError");
			}
		}
		if (password == null || password.length() < 8) {
			session.setAttribute("passwordError", "Password must be at least 8 characters long!");
			numErrors++;
		}
		else {
			if (session.getAttribute("passwordError") != null) {
				session.removeAttribute("passwordError");
			}
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
