package com.ebook.ku.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebook.ku.entities.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Integer>{

}