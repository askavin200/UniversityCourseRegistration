package com.capgemini.UniversityCourseSelection.repo;

import com.capgemini.UniversityCourseSelection.entities.AdmissionCommiteeMember;
import com.capgemini.UniversityCourseSelection.entities.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAdmissionCommiteeMemberRepository extends JpaRepository<AdmissionCommiteeMember, Integer> {

	@Query("SELECT c FROM Course c where c.courseId = ?1")
	Course getCourseById(int id);
}
