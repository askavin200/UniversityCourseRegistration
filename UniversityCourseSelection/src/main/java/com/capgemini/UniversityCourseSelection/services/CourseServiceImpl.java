package com.capgemini.UniversityCourseSelection.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.UniversityCourseSelection.entities.Course;
import com.capgemini.UniversityCourseSelection.exception.NotFoundException;
import com.capgemini.UniversityCourseSelection.repo.ICourseRepository;


@Service
public class CourseServiceImpl implements ICourseService{
	
	@Autowired
	private ICourseRepository courseRepo;

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
		else {
			throw new NotFoundException("Course with id: "+courseId+" not found!");
		}
		
	}


	@Override
	public Course updateCourse(Course course) {
		
		if(courseRepo.existsById(course.getCourseId())) {
			return courseRepo.save(course);
		}
			
		else {
			throw new NotFoundException("Course with id: "+course.getCourseId()+" not found!");
		}
	}

	@Override
	public Course viewCourse(int courseId) {
		
		if(courseRepo.existsById(courseId)) {
			return courseRepo.findById(courseId).get();
		}
		else {
			throw new NotFoundException("Course with id: "+courseId+" not found!");
		}
	}

	@Override
	public List<Course> viewAllCourses() {
		return courseRepo.findAll();
	}
	

}
