package com.codingdojo.ninjagold.models;

import java.util.Date;

public class Activity {

	private String location;
	private int gold;
	private Date date;
	private String textClass;
	
	public Activity(String location, int gold) {
		this.location = location;
		this.gold = gold;
		date = new Date();
		
		textClass = (gold < 0) ? "text-error" : "text-success";
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getTextClass() {
		return textClass;
	}
	
	public void setTextClass(String textClass) {
		this.textClass = textClass;
	}
	
	@Override
	public String toString() {
		String msg;
		
		if (location.equals("quest")) {
			if (gold < 0) {
				msg = "You failed a quest and lost " + (-gold) + " gold. Ouch.";
			}
			else {
				msg = "You completed a quest and earned " + gold + " gold.";
			}
		}
		else {
			msg = "You entered a " + location + " and ";
			if (location.equals("spa")) {
				msg += "lost " + (-gold) + " gold.";
			}
			else {
				msg += "earned " + gold + " gold.";
			}
		}
		
		msg += " (" + date.toString() + ")";
		
		return msg;
	}
}
