package com.capgemini.UniversityCourseSelection.services;

import java.util.List;

import com.capgemini.UniversityCourseSelection.entities.Admission;

public interface IAdmissionService {
	
	 	public Admission addAdmission(Admission add);
	 	public void removeAdmission(int admissionId);
	 	public Admission updateAdmission(Admission add);
	 	public Admission viewAdmission(int admissionId);
	 	public List<Admission> viewAllAdmission();

}
