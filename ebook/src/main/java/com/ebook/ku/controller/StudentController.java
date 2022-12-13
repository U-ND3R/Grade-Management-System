package com.ebook.ku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ebook.ku.entities.Student;
import com.ebook.ku.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;

	@GetMapping("/")  
	public String home(Model model) {
		model.addAttribute("students", studentService.getStudents());
		return "student_list";
	}
	
	@GetMapping("/new")  
	public String studentNew(Model model) {
		model.addAttribute("student", new Student());
		return "student_new";
	}
	
	@PostMapping("/new")
	public String addStudent(@RequestParam("name") String name, 
							 @RequestParam("surname") String surname, 
							 @RequestParam("email") String email,
							 @RequestParam("phone") String phone) {
		Student s = new Student(name, surname, email, phone);
		s = studentService.addStudent(s);
		return "redirect:/student/";
	}
	
	@GetMapping("/update/{id}")
	public String studentNew(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("student", studentService.getStudent(id));
		return "student_update";
	}
	
	@PostMapping("/update/{id}")
	public String studentUpdate(@PathVariable("id") Integer id, @ModelAttribute Student s) {
		studentService.updateStudent(s);
		return "redirect:/student/";
	}
	
	@GetMapping("/delete/{id}")
	public String studentDelete(@PathVariable("id") Integer id) {
		studentService.deleteStudent(id);
		return "redirect:/student/";
	}
}