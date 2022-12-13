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
@Table(name="grades_lecture")
public class Lecture implements Serializable{
	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	@Column(nullable = false, length = 64)
	public String name;
	
	@Column(nullable = true)
	public String description;

	
	@OneToMany(mappedBy = "grade", fetch = FetchType.LAZY)
	@JsonIgnore
	public List<Grade> grades;
	
	public Lecture() {
		
	}

	public Lecture(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	@Override
	public String toString() {
		return "Lecture [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}