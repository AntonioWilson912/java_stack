package com.codingdojo.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String welcome(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			if (session.getAttribute("increment") == null) {
				session.setAttribute("increment", 1);
			}
			Integer count = (Integer) session.getAttribute("count");
			Integer increment = (Integer) session.getAttribute("increment");
			count += increment;
			session.setAttribute("count", count);
		}
		
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		session.setAttribute("increment", 1);
		return "counter.jsp";
	}
	
	@RequestMapping("/counterByTwo")
	public String counterByTwo(HttpSession session) {
		session.setAttribute("increment", 2);
		return "counterByTwo.jsp";
	}
	
	@RequestMapping("/reset")
	public String resetCount(HttpSession session) {
		Integer oldIncrementValue = (Integer) session.getAttribute("increment");
		session.setAttribute("count", 0);
		session.setAttribute("increment", 1);
		
		return (oldIncrementValue == 1) ? "redirect:counter" : "redirect:counterByTwo";
	}
}
