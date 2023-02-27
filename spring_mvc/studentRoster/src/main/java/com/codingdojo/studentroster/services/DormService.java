package com.codingdojo.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.studentroster.models.Dorm;
import com.codingdojo.studentroster.repositories.DormRepository;

@Service
public class DormService {
	@Autowired
	DormRepository dormRepository;
	
	public DormService(DormRepository dojoRepo) {
		this.dormRepository = dojoRepo;
	}
	
	public List<Dorm> allDorms() {
		return dormRepository.findAll();
	}
	
	public Dorm createDorm(Dorm t) {
		return dormRepository.save(t);
	}
	
	public Dorm findDorm(Long id) {
		Optional<Dorm> dorm = dormRepository.findById(id);
		if (dorm.isPresent()) {
			return dorm.get();
		}
		return null;
	}
	
	public Dorm updateDorm(Dorm dorm) {
		return dormRepository.save(dorm);
	}
	
	public void deleteDorm(Long id) {
		dormRepository.deleteById(id);
	}
}
