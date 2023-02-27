package com.codingdojo.leagues.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.leagues.models.Team;
import com.codingdojo.leagues.repositories.TeamRepository;

@Service
public class TeamService {
	@Autowired
	TeamRepository teamRepository;
	
	public TeamService(TeamRepository teamRepo) {
		this.teamRepository = teamRepo;
	}
	
	public List<Team> allTeams() {
		return teamRepository.findAll();
	}
	
	public Team createTeam(Team t) {
		return teamRepository.save(t);
	}
	
	public Team findTeam(Long id) {
		Optional<Team> team = teamRepository.findById(id);
		if (team.isPresent()) {
			return team.get();
		}
		return null;
	}
	
	public Team updateTeam(Team team) {
		return teamRepository.save(team);
	}
}
