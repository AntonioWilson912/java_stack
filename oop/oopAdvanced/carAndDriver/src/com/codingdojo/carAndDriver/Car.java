package com.codingdojo.carAndDriver;

public class Car {
	protected byte gasRemaining;
	
	public Car() {
		gasRemaining = 10;
	}
	
	public void status() {
		System.out.println("Gas remaining: " + gasRemaining + "/10\n");
	}
}
