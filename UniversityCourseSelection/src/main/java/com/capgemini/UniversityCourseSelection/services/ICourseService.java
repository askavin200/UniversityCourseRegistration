package com.capgemini.UniversityCourseSelection.services;


import java.util.List;
import com.capgemini.UniversityCourseSelection.entites.Course;


public interface ICourseService {
	
	public Course addCourse(Course course);
	public Course removeCourse(int courseId);
	public Course updateCourse(Course course);
	public Course viewCourse(int courseId);
	public List<Course> viewAllCourses();

}
