package com.codingdojo.carAndDriver;

public class Driver extends Car {
	
	public void drive() {
		System.out.println("Driving the car...");
		if (gasRemaining == 0) {
			gameOver();
		}
		else {
			gasRemaining--;
			if (gasRemaining == 0) {
				gameOver();
			}
		}
		status();
	}
	
	public void boost() {
		System.out.println("Activating hyperdrive!");
		if (gasRemaining < 3) {
			System.out.println("Uh oh! Could not activate hyperdrive.");
		}
		else {
			gasRemaining -= 3;
			if (gasRemaining == 0) {
				gameOver();
			}
		}
		status();
	}
	
	public void refuel() {
		System.out.println("Refueling...");
		if (gasRemaining > 8) {
			System.out.println("Plenty of fuel. No need for more.");
		}
		else {
			gasRemaining += 2;
		}
		status();
	}
	
	private void gameOver() {
		System.out.println("Game over! You ran out of fuel!");
	}
}
