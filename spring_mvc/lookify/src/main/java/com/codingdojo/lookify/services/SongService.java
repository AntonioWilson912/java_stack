package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public Song createSong(Song s) {
		return songRepository.save(s);
	}
	
	public List<Song> allSongs() {
		return songRepository.findAll();
	}
	
	public List<Song> searchTitle(String title) {
		return songRepository.findByTitleLike(title);
	}
	
	public List<Song> searchArtist(String artist) {
		return songRepository.findByArtistContaining(artist);
	}
	
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		}
		return null;
	}
	
	public List<Song> top10() {
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	
	public Song updateSong(Song s) {
		return songRepository.save(s);
	}
	
	public Song updateSong(Long id, String title, String artist, Integer rating) {
		Song song = findSong(id);
		
		song.setTitle(title);
		song.setArtist(artist);
		song.setRating(rating);
		
		return songRepository.save(song);
	}
	
	public void destroySong(Long id) {
		songRepository.deleteById(id);
	}
}
