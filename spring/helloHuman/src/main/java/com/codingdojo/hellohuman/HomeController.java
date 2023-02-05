package com.codingdojo.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String name,
			@RequestParam(value="last_name", required=false) String lastName,
			@RequestParam(value="times", required=false) Integer times) {
		String message = "Hello ";
		if (name == null && lastName == null) {
			message += "Human";
		}
		else {
			message += name;
			if (lastName != null) {
				message += " " + lastName;
			}
		}
		
		String finalMessage = message;
		
		if (times != null && times > 1) {
			for (int i = 2; i <= times; i++) {
				finalMessage += " " + message;
			}
		}
		return finalMessage;
	}
}
