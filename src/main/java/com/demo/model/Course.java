package com.demo.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Course {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String description;
	
	@ElementCollection(targetClass=String.class)
	private List<String> steps;


	public Course(String name, String description, List<String> steps) {
		super();
		this.name = name;
		this.description = description;
		this.steps = steps;
	}


}