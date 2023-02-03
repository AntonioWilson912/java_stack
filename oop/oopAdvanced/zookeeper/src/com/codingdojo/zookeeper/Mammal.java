package com.codingdojo.zookeeper;

public class Mammal {
	protected int energyLevel;
	
	public Mammal() {
		energyLevel = 100;
	}
	
	public int displayEnergy() {
		System.out.println("Energy level: " + energyLevel);
		return energyLevel;
	}
}
