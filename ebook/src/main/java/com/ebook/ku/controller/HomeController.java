package com.ebook.ku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ebook.ku.service.GradeService;
import com.ebook.ku.service.LectureService;
import com.ebook.ku.service.StudentService;
import com.ebook.ku.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	LectureService lectureService;
	
	@Autowired
	GradeService gradeService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String home() {
		
	
		
		
		return "home";
	}
}