package com.example.basic.VO;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Any {
    @Id
	String name;
    int age;
}
