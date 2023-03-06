package com.codingdojo.studentrosternm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.studentrosternm.models.Course;
import com.codingdojo.studentrosternm.models.Dorm;
import com.codingdojo.studentrosternm.models.Student;
import com.codingdojo.studentrosternm.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> allStudents() {
		return studentRepository.findAll();
	}
	
	public Student createStudent(Student p) {
		return studentRepository.save(p);
	}
	
	public Student findStudent(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			return student.get();
		}
		
		return null;
	}
	
	public void addClassToStudent(Long studentId, Course course) {
		Student student = findStudent(studentId);
		student.getClasses().add(course);
		updateStudent(student);
	}
	
	public void dropClass(Long studentId, Course course) {
		Student student = findStudent(studentId);
		student.getClasses().remove(course);
		updateStudent(student);
	}
	
	public Student updateStudent(Student s) {
		return studentRepository.save(s);
	}
	
	public Student updateStudent(Student s, Dorm d) {
		s.setDorm(d);
		return studentRepository.save(s);
	}
	
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}
