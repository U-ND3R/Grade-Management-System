package com.ebook.ku.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="grades")
public class Grade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 11)
	private Integer grade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="lecture_id")
	@JsonIgnore
	private Lecture lecture;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="student_id")
	@JsonIgnore
	private Student student;
	
	public Grade() {
		
	}
	
	public Grade(Integer grade) {
		this.grade = grade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Grade [id=" + id + ", grade=" + grade + "]";
	}
}