package com.codingdojo.helloworld;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DojoController {

	@RequestMapping("/dojos")
	public String dojos(Model model) {
		ArrayList<String> dojos = new ArrayList<String>();
		dojos.add("Burbank");
		dojos.add("Chicago");
		dojos.add("Bellevue");
		dojos.add("San Diego");
		model.addAttribute("dojosFromMyController", dojos);
		return "dojo.jsp";
	}
}
