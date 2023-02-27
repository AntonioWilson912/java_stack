package com.codingdojo.leagues.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.leagues.models.Player;
import com.codingdojo.leagues.repositories.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	PlayerRepository playerRepository;
	
	public List<Player> allPlayers() {
		return playerRepository.findAll();
	}
	
	public Player createPlayer(Player p) {
		return playerRepository.save(p);
	}
	
	public Player findPlayer(Long id) {
		Optional<Player> player = playerRepository.findById(id);
		if (player.isPresent()) {
			return player.get();
		}
		
		return null;
	}
	
	public Player updatePlayer(Player p) {
		return playerRepository.save(p);
	}
}
