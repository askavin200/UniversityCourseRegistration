package com.capgemini.UniversityCourseSelection.services;

import java.util.List;

import com.capgemini.UniversityCourseSelection.entities.Course;
import com.capgemini.UniversityCourseSelection.entities.UniversityStaffMember;
import com.capgemini.UniversityCourseSelection.repo.ICourseRepository;
import com.capgemini.UniversityCourseSelection.repo.IUniversityStaffMemberRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class IUniversityStaffServiceImpl implements IUniversityStaffService{
	
	@Autowired
	private IUniversityStaffMemberRepository staffRepo;
	@Autowired
	private ICourseRepository courseRepo;
	
	@Override
	public UniversityStaffMember addStaff(UniversityStaffMember usm) {
		return staffRepo.save(usm);
	}

	@Override
	public UniversityStaffMember updateStaff(UniversityStaffMember usm) {
		if(staffRepo.existsById(usm.getStaffId())) {
			return staffRepo.save(usm);
		}
		return null;
	}

	@Override
	public UniversityStaffMember viewStaff(int id) {
		return staffRepo.getReferenceById(null);
	}

	@Override
	public void removeStaff(int id) {
		staffRepo.deleteById(id);		
	}

	@Override
	public List<UniversityStaffMember> viewAllStaffs() {
		return staffRepo.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		return courseRepo.save(course);
	}

	@Override
	public Course removeCourse(Course course) {
		if(courseRepo.existsById(course.getCourseId())) {
			courseRepo.deleteById(course.getCourseId());
			return course;
		}
		return null;
	}

	@Override
	public Course updateCourse(Course course) {
		if(courseRepo.existsById(course.getCourseId())) {
			return courseRepo.save(course);
		}
		return null;
	}
  
}
