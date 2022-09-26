package com.capgemini.UniversityCourseSelection.services;

import java.util.List;

import com.capgemini.UniversityCourseSelection.entites.AdmissionStatus;
import com.capgemini.UniversityCourseSelection.entites.Applicant;
public interface IApplicantService {
	
	
	Applicant addApplicant(Applicant app);
 	Applicant updateApplicant(Applicant app);
 	Applicant deleteApplicant(Applicant app);
 	Applicant viewApplicant(int id);
 	List<Applicant> viewAllApplicantsByStatus(AdmissionStatus status);

}
