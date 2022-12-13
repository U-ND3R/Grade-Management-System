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
import com.ebook.ku.entities.Lecture;
import com.ebook.ku.service.LectureService;

@Controller
@RequestMapping("/lecture")
public class LectureController {
	@Autowired
	LectureService lectureService;

	@GetMapping("/")  
	public String home(Model model) {
		model.addAttribute("lectures", lectureService.getLectures());
		return "lecture_list";
	}
	
	@GetMapping("/new")  
	public String lectureNew(Model model) {
		model.addAttribute("lecture", new Lecture());
		return "lecture_new";
	}
	
	@PostMapping("/new")
	public String addLecture(@RequestParam("name") String name, 
							 @RequestParam("description") String description) {
		Lecture l = new Lecture(name, description);
		l = lectureService.addLecture(l);
		return "redirect:/lecture/";
	}
	
	@GetMapping("/update/{id}")
	public String lectureNew(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("lecture", lectureService.getLecture(id));
		return "lecture_update";
	}
	
	@PostMapping("/update/{id}")
	public String lectureUpdate(@PathVariable("id") Integer id, @ModelAttribute Lecture l) {
		lectureService.updateLecture(l);
		return "redirect:/lecture/";
	}
	
	@GetMapping("/delete/{id}")
	public String lectureDelete(@PathVariable("id") Integer id) {
		lectureService.deleteLecture(id);
		return "redirect:/lecture/";
	}
}