package com.codingdojo.abstractArt;

public class ArtworkTest {

	public static void main(String[] args) {
		Painting p1 = new Painting("Starry Night", 
				"Vincent Van Gogh", "Night skies", "Watercolor");
		Painting p2 = new Painting("Mona Lisa", 
				"Leonardo da Vinci", "The most parodied work of art in the world", "Oil Paint");
		Painting p3 = new Painting("The Last Supper", 
				"Leonardo da Vinci", "Christian art", "Tempura");
		
		Museum museum = new Museum();
		museum.addArtwork(p1);
		museum.addArtwork(p2);
		museum.addArtwork(p3);
		
		museum.viewArt();
		
		Sculpture s1 = new Sculpture("David",
				"Michaelangelo",
				"Kinetic art", "Carrara marble");
		Sculpture s2 = new Sculpture("Perseus with the Head of Medusa",
				"Benvenuto Cellini",
				"Perseus and Andromeda", "Bronze");
		
		museum.addArtwork(s1);
		museum.addArtwork(s2);
		
		museum.viewArt();
	}

}
