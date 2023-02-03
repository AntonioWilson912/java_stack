package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {

	//... imports class definition...
	
	// Inside class:    
	private ArrayList<String> patientNotes;
	
	// TO DO: Constructor that takes an ID
	public Physician(Integer id) {
		super(id);
		patientNotes = new ArrayList<String>();
	}

    // TO DO: Implement HIPAACompliantUser!
	@Override
	public boolean assignPin(int pin) {
		if (pin < 1000 || pin > 9999) {
			return false;
		}
		setPIN(pin);
		return true;
	}
	

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		return getID().equals(confirmedAuthID);
	}
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters
    public void setPatientNotes(ArrayList<String> patientNotes) {
    	this.patientNotes = patientNotes;
    }
    
    public ArrayList<String> getPatientNotes() {
    	return patientNotes;
    }
	

}
