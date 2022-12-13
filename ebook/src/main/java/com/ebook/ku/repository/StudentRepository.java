package com.ebook.ku.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebook.ku.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}