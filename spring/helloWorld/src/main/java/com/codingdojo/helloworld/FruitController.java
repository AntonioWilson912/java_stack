package com.codingdojo.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FruitController {

	@RequestMapping("/fruit")
	public String fruitOfTheDay(Model model) {
		model.addAttribute("fruit", "banana");
		model.addAttribute("special", "pineapple smoothie");
		
		model.addAttribute("objFruit", new Fruit("kiwi"));
		return "demo.jsp";
	}
}
