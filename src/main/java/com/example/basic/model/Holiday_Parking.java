package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Holiday_Parking {
	@Id
	@GeneratedValue
	Long id;
	String institution, manager, tel, sido, gu, adrress,
	name, loc, type, lng, lat, etc;
}
