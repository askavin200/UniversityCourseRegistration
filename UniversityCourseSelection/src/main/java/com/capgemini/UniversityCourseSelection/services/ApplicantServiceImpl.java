package com.capgemini.UniversityCourseSelection.services;

import java.util.List;

import com.capgemini.UniversityCourseSelection.entities.AdmissionStatus;
import com.capgemini.UniversityCourseSelection.entities.Applicant;
import com.capgemini.UniversityCourseSelection.repo.IApplicantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ApplicantServiceImpl implements IApplicantService {
	
	@Autowired
	IApplicantRepository repo;

	@Override
	public Applicant addApplicant(Applicant app) {
		return repo.save(app);
	}

	@Override
	public Applicant updateApplicant(Applicant app) {
		return repo.save(app);
	}

	@Override
	public Applicant deleteApplicant(Applicant app) {
		repo.delete(app);
		return app;
	}

	@Override
	public Applicant viewApplicant(int id) {
	   Applicant res= repo.findById(id).get();
	   return res;
	}

	@Override
	public List<Applicant> viewAllApplicantsByStatus(AdmissionStatus status) {
		  return repo.viewAllApplicantByCourse(status);
	}

}
