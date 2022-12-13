package com.ebook.ku.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebook.ku.entities.Grade;

public interface GradeRepository extends JpaRepository<Grade, Integer>{

}