package com.codingdojo.studentrosternm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.studentrosternm.models.Course;
import com.codingdojo.studentrosternm.models.Student;
import com.codingdojo.studentrosternm.repositories.ClassRepository;

@Service
public class ClassService {

	@Autowired
	ClassRepository classRepository;
	
	public List<Course> allClasses() {
		return classRepository.findAll();
	}
	
	public Course createClass(Course c) {
		return classRepository.save(c);
	}
	
	public Course findClass(Long id) {
		Optional<Course> course = classRepository.findById(id);
		
		return course.isPresent() ? course.get() : null;
	}
	
	public List<Course> allCoursesStudentNotIn(Student s) {
		return classRepository.findByStudentsNotContains(s);
	}
}
