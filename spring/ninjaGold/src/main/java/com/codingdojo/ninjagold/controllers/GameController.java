package com.codingdojo.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.ninjagold.models.Activity;

@Controller
public class GameController {

	@GetMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if (session.getAttribute("activityLog") == null) {
			session.setAttribute("activityLog", new ArrayList<Activity>());
		}
		return "index.jsp";
	}
	
	@PostMapping("/process")
	public String processGold(@RequestParam(value="location") String location, HttpSession session) {
		Random randMachine = new Random();
		Integer sessionGold = (Integer)session.getAttribute("gold");
		int gold;
		
		if (location.equals("farm")) {
			gold = randMachine.nextInt(10, 21);
		}
		else if (location.equals("cave")) {
			gold = randMachine.nextInt(5, 11);
		}
		else if (location.equals("house")) {
			gold = randMachine.nextInt(2, 6);
		}
		else if (location.equals("quest")) {
			gold = randMachine.nextInt(-50, 51);
		}
		else {
			gold = randMachine.nextInt(-20, -4);
		}
		
		Activity newActivity = new Activity(location, gold);
		
		ArrayList<Activity> activityLog = (ArrayList<Activity>) session.getAttribute("activityLog");
		
		activityLog.add(0, newActivity);
		
		sessionGold += gold;
		
		session.setAttribute("activityLog", activityLog);
		session.setAttribute("gold", sessionGold);
		
		if (sessionGold < -100) {
			return "redirect:/prison";
		}
		
		
		return "redirect:/";
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("gold", 0);
		session.setAttribute("activityLog", new ArrayList<Activity>());
		
		return "redirect:/";
	}
	
	@GetMapping("/prison")
	public String prison() {
		return "lose.jsp";
	}
	
}
