package com.capgemini.UniversityCourseSelection.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.UniversityCourseSelection.entities.Admission;
import com.capgemini.UniversityCourseSelection.entities.AdmissionCommiteeMember;
import com.capgemini.UniversityCourseSelection.entities.AdmissionStatus;
import com.capgemini.UniversityCourseSelection.entities.Applicant;
import com.capgemini.UniversityCourseSelection.entities.Course;
import com.capgemini.UniversityCourseSelection.repo.IAdmissionCommiteeMemberRepository;

public class AdmissionCommitteeMemberServiceImpl implements IAdmissionCommiteeMemberService {

	@Autowired
	private IAdmissionCommiteeMemberRepository repo;

	@Autowired
	IApplicantService applicantRepo;


	@Override
	public AdmissionCommiteeMember addCommitteeMember(AdmissionCommiteeMember member) {
		return repo.save(member);
	}

	@Override
	public AdmissionCommiteeMember updateCommitteeMember(AdmissionCommiteeMember member) {
		return repo.save(member);
	}

	@Override
	public AdmissionCommiteeMember viewCommitteeMember(int id) {
		AdmissionCommiteeMember member = repo.findById(id).get();
		return member;
	}

	@Override
	public void removeCommitteeMember(int id) {
		repo.deleteById(id);
	}

	@Override
	public List<AdmissionCommiteeMember> viewAllCommitteeMembers() {
		List<AdmissionCommiteeMember> l = repo.findAll();
		return l;
	}

	@Override
	public AdmissionStatus provideAdmissionResult(Applicant applicant, Admission admission) {

		// get the course object
		Course course = null;
		int id = admission.getCourseId();
		course = repo.getCourseById(id);

		// if course is not found, return admission status as rejected/pending
		if (course == null) {
			return AdmissionStatus.REJECTED;
		}

		// criteria 1 (admission date)
		LocalDate admissionDate = admission.getAdmissionDate();
		LocalDate courseStartDate = course.getCourseStartDate();

		if (admissionDate.isAfter(courseStartDate)) {
			// set the status for the admission and applicant as REJECTED object and save them
			// confused , whether we have to save or not
			return AdmissionStatus.REJECTED;
		}
		// criteria 1 satisfied

		// criteria 2 ( percentage )
		double courseCriteria = course.getCourseCriteria();
		double marks = applicant.getApplicantGraduationPercent();

		if (marks < courseCriteria) {
			// set the status for the admission and applicant as PENDING object and save them
			// confused , whether we have to save or not
			return AdmissionStatus.PENDING;
		}

		// criteria 2 satisfied
		// change the admission and applicant status as confirmed
		return AdmissionStatus.CONFIRMED;

	}

}
