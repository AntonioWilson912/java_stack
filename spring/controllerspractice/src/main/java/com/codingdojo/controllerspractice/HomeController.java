package com.codingdojo.controllerspractice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping("/world")
	public String world() {
		return "You are my world!";
	}
}
