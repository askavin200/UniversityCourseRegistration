package com.capgemini.UniversityCourseSelection.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.UniversityCourseSelection.entities.Course;
import com.capgemini.UniversityCourseSelection.services.ICourseService;


@RestController
@RequestMapping("/uni")
public class CourseController {
	
	@Autowired
	ICourseService courseService;
	
	@GetMapping("/viewCourseById/{courseId}")
	public ResponseEntity<Course> viewCourseById(@PathVariable("courseId") int courseId) {
		
		Course viewCourse = courseService.viewCourse(courseId);
		
		if(viewCourse == null) 
			return new ResponseEntity("Soryy, no Course found!!", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Course>(viewCourse, HttpStatus.OK); 
	}
	
	@GetMapping("/viewAllCourses")
	public ResponseEntity<List<Course>> viewAllCourses(){
		
		List<Course> courses = courseService.viewAllCourses();
		
		if(courses.isEmpty()) 
			return new ResponseEntity("Soryy, no Courses available!!", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Course>>(courses, HttpStatus.OK); 
		
	}

}
