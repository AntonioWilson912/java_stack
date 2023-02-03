package com.codingdojo.abstractArt;

public class Sculpture extends Art {
	
	private String material;
	
	public Sculpture(String title, String author, String description, String material) {
		super(title, author, description);
		setMaterial(material);
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public void viewArt() {
		System.out.println("Sculpture Information:");
		System.out.printf("Title: %s\n", getTitle());
		System.out.printf("Author: %s\n", getAuthor());
		System.out.printf("Description: %s\n", getDescription());
		System.out.printf("Material: %s\n\n", getMaterial());
	}

}
