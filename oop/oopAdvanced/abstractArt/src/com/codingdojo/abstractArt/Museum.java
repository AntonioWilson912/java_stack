package com.codingdojo.abstractArt;

import java.util.ArrayList;
import java.util.Random;

public class Museum {
	
	private ArrayList<Art> artwork;
	
	public Museum() {
		artwork = new ArrayList<Art>();
	}
	
	public Museum(ArrayList<Art> artwork) {
		this.artwork = artwork;
	}
	
	public void addArtwork(Art newArtwork) {
		this.artwork.add(newArtwork);
	}
	
	public void setArtwork(ArrayList<Art> artwork) {
		this.artwork = artwork;
	}
	
	public ArrayList<Art> getArtwork() {
		return artwork;
	}
	
	public void viewArt() {
		System.out.println("----Displaying all artwork in the museum----");
		
		// Shuffle the order of artwork
		Random randMachine = new Random();
		for (int i = 0; i < artwork.size(); i++) {
			int randIndex = randMachine.nextInt(artwork.size());
			Art randArt = artwork.get(randIndex);
			artwork.set(randIndex, artwork.get(i));
			artwork.set(i, randArt);
		}
		for (Art art : artwork) {
			art.viewArt();
		}
	}
}
