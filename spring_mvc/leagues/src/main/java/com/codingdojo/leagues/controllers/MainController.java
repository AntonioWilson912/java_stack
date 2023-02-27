package com.codingdojo.leagues.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.leagues.models.Player;
import com.codingdojo.leagues.models.Team;
import com.codingdojo.leagues.services.PlayerService;
import com.codingdojo.leagues.services.TeamService;

@Controller
public class MainController {
	
	@Autowired
	TeamService teamService;
	
	@Autowired
	PlayerService playerService;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("teams", teamService.allTeams());
		return "index.jsp";
	}
	
	@GetMapping("/players/new")
	public String newPlayer(@ModelAttribute("player") Player player, Model model) {
		model.addAttribute("teams", teamService.allTeams());
		return "new_player.jsp";
	}
	
	@PostMapping("/players/new")
	public String createPlayer(@Valid @ModelAttribute("player") Player player, BindingResult result) {
		if (result.hasErrors()) {
			return "new_player.jsp";
		}
		
		playerService.createPlayer(player);
		return "redirect:/";
	}
	
	@GetMapping("/teams/new")
	public String newTeam(@ModelAttribute("team") Team team) {
		return "new_team.jsp";
	}
	
	@PostMapping("/teams/new")
	public String createTeam(@Valid @ModelAttribute("team") Team team, BindingResult result) {
		if (result.hasErrors()) {
			return "new_team.jsp";
		}
		teamService.createTeam(team);
		return "redirect:/";
	}
	
	@GetMapping("/teams/{id}")
	public String showTeam(@PathVariable("id") Long id, Model model) {
		model.addAttribute("team", teamService.findTeam(id));
		return "view_team.jsp";
	}
	
}
