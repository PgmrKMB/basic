package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(exclude = "dept")
public class EMP {

	@Id
	@GeneratedValue
	private int empno;
	
	String ename;
	String job;
	String mgr;
	String hiredate;
	int sal;
	int comm;
	
	@ManyToOne
	@JoinColumn(name = "deptno")
	Dept dept;
	
}
