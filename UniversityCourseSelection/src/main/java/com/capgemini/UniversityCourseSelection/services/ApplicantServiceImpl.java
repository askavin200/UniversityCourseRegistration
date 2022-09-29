	package com.capgemini.UniversityCourseSelection.services;

import java.util.List;
import java.util.Optional;

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
		Applicant temp=repo.save(app);
		temp.getAdmission().setApplicantId(temp.getApplicantId());
		return repo.save(temp);
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
	public Optional<Applicant> viewApplicant(int id) {
	   Optional<Applicant> res= repo.findById(id);
	   return res;
	}

	@Override
	public List<Applicant> viewAllApplicantsByStatus(int status) {
		  return repo.viewAllApplicantByCourse(status);
	}

}
