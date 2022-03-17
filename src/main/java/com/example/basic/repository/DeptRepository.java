package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.model.Dept;

public interface DeptRepository extends JpaRepository<Dept, Short> {

}
