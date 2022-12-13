package com.ebook.ku.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.ku.entities.Student;
import com.ebook.ku.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	public StudentRepository studentRepository;
	
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	public Student updateStudent(Student student) {
		Student old = studentRepository.getReferenceById(student.getId());
		old.setName(student.getName());
		old.setSurname(student.getSurname());
		old.setEmail(student.getEmail());
		old.setPhone(student.getPhone());
		studentRepository.save(old);
		return old;
	}
	
	public void deleteStudent(Integer id) {
		studentRepository.deleteById(id);
	}
	
	public Student getStudent(Integer id) {
		return studentRepository.findById(id).get();
	}
	
}