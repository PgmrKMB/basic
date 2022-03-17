package com.example.basic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Dept {

	@Id
	@GeneratedValue
	short deptno;
	
	String dname;
	String loc;
	
	@OneToMany(mappedBy = "dept", fetch = FetchType.EAGER)
	List<EMP> emps = new ArrayList<>();
}
