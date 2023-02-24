package com.codingdojo.lookify.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@Controller
public class SongController {
	
	@Autowired
	SongService songService;

	@GetMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		ArrayList<Song> songs = (ArrayList<Song>)songService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@GetMapping("/songs/new")
	public String addSong(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}
	
	@PostMapping("/dashboard")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		}
		songService.createSong(song);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/search")
	public String searchSongsByArtist(@RequestParam("artist") String artist) {
		if (artist.length() == 0) {
			return "redirect:/dashboard";
		}
		return "redirect:/search/" + artist;
	}
	
	@GetMapping("/search/{artist}")
	public String searchArtist(@PathVariable("artist") String artist, Model model) {
		ArrayList<Song> songsByArtist = (ArrayList<Song>)songService.searchArtist(artist);
		model.addAttribute("songsByArtist", songsByArtist);
		model.addAttribute("artist", artist);
		return "search.jsp";
	}
	
	@GetMapping("/songs/{id}")
	public String showSong(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "show.jsp";
	}
	
	@DeleteMapping("/songs/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		songService.destroySong(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/songs/top-ten")
	public String top10(Model model) {
		ArrayList<Song> top10Songs = (ArrayList<Song>)songService.top10();
		model.addAttribute("top10Songs", top10Songs);
		return "top.jsp";
	}
}
