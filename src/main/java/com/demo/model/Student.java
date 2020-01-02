package com.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.*;

@Entity
@NoArgsConstructor
@Data
public class Student {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Course> courses;

	public Student(String name, String description,
			List<Course> courses) {
		super();
		this.name = name;
		this.description = description;
		this.courses = courses;
	}

}