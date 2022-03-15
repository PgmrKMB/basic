package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.Demo;

@Repository // @생략가능
public interface DemoRepository extends JpaRepository<Demo, Long> {

}
