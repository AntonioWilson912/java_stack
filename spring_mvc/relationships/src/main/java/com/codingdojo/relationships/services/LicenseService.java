package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.LicenseRepository;
import com.codingdojo.relationships.repositories.PersonRepository;

@Service
public class LicenseService {
	
	private final LicenseRepository licenseRepository;
	private final PersonRepository personRepository;
	
	public LicenseService(LicenseRepository licenseRepo, PersonRepository personRepository) {
		this.licenseRepository = licenseRepo;
		this.personRepository = personRepository;
	}
	
	public List<License> allLicenses() {
		return licenseRepository.findAll();
	}
	
	public List<Person> allPeople() {
		return personRepository.findAll();
	}
	
	public License createLicense(License p) {
		return licenseRepository.save(p);
	}
	
	public License findLicense(long id) {
		Optional<License> license = licenseRepository.findById(id);
		if (license.isPresent()) {
			return license.get();
		}
		return null;
	}
}
