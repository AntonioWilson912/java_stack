package com.codingdojo.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();
	List<Song> findByTitleLike(String pattern);
	List<Song> findTop10ByOrderByRatingDesc();
	List<Song> findByArtistContaining(String pattern);
}
