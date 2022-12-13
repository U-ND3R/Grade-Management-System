package com.ebook.ku.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.ku.entities.Grade;
import com.ebook.ku.repository.GradeRepository;

@Service
public class GradeService {
	@Autowired
	public GradeRepository gradeRepository;
	
	public Grade addGrade(Grade grade) {
		return gradeRepository.save(grade);
	}
	
	public List<Grade> getGrades(){
		return gradeRepository.findAll();
	}
	
	public Grade updateGrade(Grade grade) {
		Grade old=gradeRepository.getReferenceById(grade.getId());
		old.setGrade(grade.getGrade());
		gradeRepository.save(old);
		return old;
	}
	
	public void deleteGrade(Integer id) {
		gradeRepository.deleteById(id);
	}
	
	public Grade getGrade(Integer id) {
		return gradeRepository.findById(id).get();
	}
	
}