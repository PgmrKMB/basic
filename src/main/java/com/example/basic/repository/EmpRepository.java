package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.model.EMP;

public interface EmpRepository extends JpaRepository<EMP, Integer>{

}
