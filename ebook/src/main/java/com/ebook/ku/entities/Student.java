package com.ebook.ku.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="grades_student")
public class Student implements Serializable{
	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	@Column(nullable = false, length = 64)
	public String name;
	
	@Column(nullable = false, length = 64)
	public String surname;
	
	@Column(nullable = false, length = 64)
	public String email;
	
	@Column(nullable = false, length = 32)
	public String phone;

	
	@OneToMany(mappedBy = "grade", fetch = FetchType.LAZY)
	@JsonIgnore
	public List<Grade> grades;
	
	public Student() {
		
	}

	public Student(String name, String surname, String email, String phone) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone + "]";
	}
}