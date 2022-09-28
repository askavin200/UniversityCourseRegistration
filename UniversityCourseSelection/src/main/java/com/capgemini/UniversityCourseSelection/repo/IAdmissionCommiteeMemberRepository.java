package com.capgemini.UniversityCourseSelection.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.UniversityCourseSelection.entities.AdmissionCommiteeMember;
import com.capgemini.UniversityCourseSelection.entities.Course;

@Repository
public interface IAdmissionCommiteeMemberRepository extends JpaRepository<AdmissionCommiteeMember, Integer> {

	@Query("SELECT c FROM Course c where c.courseId = ?1")
	Course getCourseById(int id);
}
