package com.codingdojo.zookeeper;

public class Bat extends Mammal {
	public Bat() {
		energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("Flap flap! Bat is flying!");
		energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("It's not cannibalism.");
		energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("Ah! It's on fire!");
		energyLevel -= 100;
	}
}
