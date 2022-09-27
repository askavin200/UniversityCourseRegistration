package com.capgemini.UniversityCourseSelection.repo;

import java.util.List;

import com.capgemini.UniversityCourseSelection.entites.AdmissionStatus;
import com.capgemini.UniversityCourseSelection.entites.Applicant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface IApplicantRepository extends JpaRepository<Applicant, Integer>{
	
	
	@Query(value="select * from Applicant where status=?1",nativeQuery = true)
	List<Applicant> viewAllApplicantByCourse(AdmissionStatus status);
	
	

}
