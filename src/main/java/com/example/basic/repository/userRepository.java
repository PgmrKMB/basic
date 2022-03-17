package com.example.basic.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.model.User;

public interface userRepository extends JpaRepository<User, String>{

	User findByUserId(String userId);

}
