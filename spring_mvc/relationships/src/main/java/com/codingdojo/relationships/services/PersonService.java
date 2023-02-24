package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepo) {
		this.personRepository = personRepo;
	}
	
	public List<Person> allPersons() {
		return personRepository.findAll();
	}
	
	public Person createPerson(Person p) {
		return personRepository.save(p);
	}
	
	public Person findPerson(long id) {
		Optional<Person> person = personRepository.findById(id);
		if (person.isPresent()) {
			return person.get();
		}
		return null;
	}
}
