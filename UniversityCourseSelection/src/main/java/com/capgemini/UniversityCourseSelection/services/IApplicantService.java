package com.capgemini.UniversityCourseSelection.services;

import java.util.List;

import com.capgemini.UniversityCourseSelection.entities.AdmissionStatus;
import com.capgemini.UniversityCourseSelection.entities.Applicant;
public interface IApplicantService {
	
	
	Applicant addApplicant(Applicant app);
 	Applicant updateApplicant(Applicant app);
 	Applicant deleteApplicant(Applicant app);
 	Applicant viewApplicant(int id);
 	List<Applicant> viewAllApplicantsByStatus(AdmissionStatus status);

}
