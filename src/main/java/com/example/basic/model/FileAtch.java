package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class FileAtch {
	@Id
	@GeneratedValue
	Long id;
	
	String originalName;
	
}
