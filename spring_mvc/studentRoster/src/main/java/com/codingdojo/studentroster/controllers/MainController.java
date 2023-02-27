package com.codingdojo.studentroster.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.studentroster.models.Dorm;
import com.codingdojo.studentroster.models.Student;
import com.codingdojo.studentroster.services.DormService;
import com.codingdojo.studentroster.services.StudentService;

@Controller
public class MainController {
	
	@Autowired
	DormService dormService;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("dorms", dormService.allDorms());
		return "index.jsp";
	}
	
	@GetMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("dorms", dormService.allDorms());
		return "new_student.jsp";
	}
	
	@PostMapping("/students/new")
	public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "new_student.jsp";
		}
		
		studentService.createStudent(student);
		return "redirect:/";
	}
	
	@GetMapping("/dorms/new")
	public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
		return "new_dorm.jsp";
	}
	
	@PostMapping("/dorms/new")
	public String createDorm(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
		if (result.hasErrors()) {
			return "new_dorm.jsp";
		}
		dormService.createDorm(dorm);
		return "redirect:/";
	}
	
	@GetMapping("/dorms/{id}")
	public String showDorm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dorm", dormService.findDorm(id));
		model.addAttribute("students", studentService.allStudents());
		return "view_dorm.jsp";
	}
	
	@DeleteMapping("/dorms/{dorm_id}")
	public String deleteDorm(@PathVariable("dorm_id") Long dormId) {
		dormService.deleteDorm(dormId);
		return "redirect:/";
	}
	
	@PutMapping("/dorms/{dorm_id}")
	public String addStudent(@PathVariable("dorm_id") Long dormId, @RequestParam("addStudent") Long studentId) {
		studentService.updateStudent(studentService.findStudent(studentId), dormService.findDorm(dormId));
		return "redirect:/dorms/" + dormId;
	}
	
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable("studentId") Long studentId) {
		studentService.deleteStudent(studentId);
		return "redirect:/";
	}
	
}
