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
import com.ebook.ku.entities.Grade;
import com.ebook.ku.service.GradeService;

@Controller
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	GradeService gradeService;
	
	@GetMapping("/")  
	public String home(Model model) {
		model.addAttribute("grades", gradeService.getGrades());
		return "grade_list";
	}
	
	@GetMapping("/new")  
	public String gradeNew(Model model) {
		model.addAttribute("grade", new Grade());
		return "grade_new";
	}
	
	@PostMapping("/new")
	public String addGrade(	@RequestParam("grade") Integer grade) {
		Grade g = new Grade(grade);
		g = gradeService.addGrade(g);
		return "redirect:/grade/";
	}
	
	@GetMapping("/update/{id}")
	public String gradeNew(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("grade", gradeService.getGrade(id));
		return "grade_update";
	}
	
	@PostMapping("/update/{id}")
	public String gradeUpdate(@PathVariable("id") Integer id, @ModelAttribute Grade g) {
		gradeService.updateGrade(g);
		return "redirect:/grade/";
	}
	
	@GetMapping("/delete/{id}")
	public String gradeDelete(@PathVariable("id") Integer id) {
		gradeService.deleteGrade(id);
		return "redirect:/grade/";
	}
}