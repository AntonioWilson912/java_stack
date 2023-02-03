package com.codingdojo.zookeeper;

public class Gorilla extends Mammal {
	
	public void throwSomething() {
		System.out.println("No happy! Throwing rocks!");
		energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("Going bananas after eating bananas!");
		energyLevel += 10;
	}
	
	public void climb() {
		System.out.println("Gorilla has climbed a tree!");
		energyLevel -= 10;
	}
	
}
