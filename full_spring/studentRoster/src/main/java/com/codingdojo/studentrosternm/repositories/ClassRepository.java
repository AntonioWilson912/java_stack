package com.codingdojo.studentrosternm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.studentrosternm.models.Course;
import com.codingdojo.studentrosternm.models.Student;

@Repository
public interface ClassRepository extends CrudRepository<Course, Long> {
	List<Course> findAll();
	List<Course> findByStudentsNotContains(Student s);
}
