package com.ebook.ku.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.ku.entities.Lecture;
import com.ebook.ku.repository.LectureRepository;

@Service
public class LectureService {
	@Autowired
	public LectureRepository lectureRepository;
	
	public Lecture addLecture(Lecture lecture) {
		return lectureRepository.save(lecture);
	}
	
	public List<Lecture> getLectures(){
		return lectureRepository.findAll();
	}
	
	public Lecture updateLecture(Lecture lecture) {
		Lecture old = lectureRepository.getReferenceById(lecture.getId());
		old.setName(lecture.getName());
		old.setDescription(lecture.getDescription());
		lectureRepository.save(old);
		return old;
	}
	
	public void deleteLecture(Integer id) {
		lectureRepository.deleteById(id);
	}
	
	public Lecture getLecture(Integer id) {
		return lectureRepository.findById(id).get();
	}
	
}