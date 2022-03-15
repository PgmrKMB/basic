package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Demo {
	@Id
//	@GeneratedValue
	Long seq;
	String user;
}
