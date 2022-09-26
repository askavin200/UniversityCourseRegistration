package com.capgemini.mts.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.mts.entities.Course;
import com.capgemini.mts.repo.CourseRepo;
import com.capgemini.mts.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService{
	
	@Autowired
	private CourseRepo courseRepo;

	@Override
	@Transactional
	public Course addCourse(Course course) {
		return courseRepo.save(course);
	}

	@Override
	@Transactional
	public Course removeCourse(int courseId) {
		Course deletedCourse = null;
		if(courseRepo.existsById(courseId)) {
			deletedCourse = courseRepo.findById(courseId).get();
			courseRepo.deleteById(courseId);
			return deletedCourse;
		}
			
		return deletedCourse;
	}

	@Override
	public Course updateCourse(Course course) {
		Course updatedCourse = null;
		if(courseRepo.existsById(course.getCourseId())) 
			updatedCourse = courseRepo.save(course);
		
		return updatedCourse;
	}

	@Override
	public Course viewCourse(int courseId) {
		Course course = null;
		try {
			course = courseRepo.findById(courseId).get();
		} catch (Exception e) {
		}
		
		return course;
	}

	@Override
	public List<Course> viewAllCourses() {
		return courseRepo.findAll();
	}
	

}
