package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Night_Pharmacy {

	@Id
	private Long id;
	private String name, tel, roadAddress, jibunAddress,
	mon, tue, thu, fri, sat, sun, pubDay;
}
