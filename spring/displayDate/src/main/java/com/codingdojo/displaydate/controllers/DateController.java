package com.codingdojo.displaydate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.text.SimpleDateFormat;

@Controller
public class DateController {
	
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat();
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String dateTemplate(Model model) {
		Date date = new Date();
		
		// Tuesday, Jan 23, 2049
		dateTimeFormat.applyPattern("EEEE, MMM dd, yyyy");
		
		model.addAttribute("theDate", dateTimeFormat.format(date));
		
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String timeTemplate(Model model) {
		Date date = new Date();
		
		// 6:26 PM
		dateTimeFormat.applyPattern("h:mm a");
		model.addAttribute("theTime", dateTimeFormat.format(date));
		
		return "time.jsp";
	}
}
