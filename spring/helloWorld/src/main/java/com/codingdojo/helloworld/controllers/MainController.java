package com.codingdojo.helloworld.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
