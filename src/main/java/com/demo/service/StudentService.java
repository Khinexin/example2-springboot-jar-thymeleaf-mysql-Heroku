package com.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Course;
import com.demo.model.Student;
import com.demo.repository.CourseRepository;
import com.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired StudentRepository studentRepository;
	@Autowired CourseRepository courseRepository;

	
	public void initializeStudentCourse() {
		
		if(studentRepository.count() == 0) {
			
			Course course1 = new Course( "Spring", "10 Steps",
					Arrays.asList("Learn Maven", "Import Project", "First Example",
							"Second Example"));
			
			Course course2 = new Course("Spring MVC", "10 Examples",
					Arrays.asList("Learn Maven", "Import Project", "First Example",
							"Second Example"));

			Student ranga = new Student("Ranga Karanam",
					"Hiker, Programmer and Architect", new ArrayList<>(
							Arrays.asList(course1, course2)));

			studentRepository.save(ranga);
			
		}
	}
	
	public List<Student> studentList(){
		initializeStudentCourse();
		return studentRepository.findAll();
	}
	
	public List<Course> findCourseByStudentId(int studentId){
		Student student = studentRepository.getOne(studentId);
		return student.getCourses();
	}

}