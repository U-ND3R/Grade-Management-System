package com.ebook.ku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ebook.ku.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}