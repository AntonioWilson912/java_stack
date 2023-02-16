package com.codingdojo.helloworld.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

	@RequestMapping("/session")
	public String setValue(HttpSession session) {
		session.setAttribute("name", "George");
		return "session.jsp";
	}
	
	@RequestMapping("/seeSession")
	public String seeSession() {
		return "session.jsp";
	}
	
	@RequestMapping("/createError")
	public String flashMessage(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "This is a test error!");
		return "redirect:/errorTest";
	}
	
	@RequestMapping("/errorTest")
	public String errorTest() {
		return "attribute.jsp";
	}
}
