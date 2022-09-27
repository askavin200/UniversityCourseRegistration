package com.capgemini.UniversityCourseSelection.services;

import java.util.List;

import com.capgemini.UniversityCourseSelection.entites.Admission;
import com.capgemini.UniversityCourseSelection.entites.AdmissionCommiteeMember;
import com.capgemini.UniversityCourseSelection.entites.AdmissionStatus;
import com.capgemini.UniversityCourseSelection.entites.Applicant;

public interface IAdmissionCommiteeMemberService {

	AdmissionCommiteeMember addCommitteeMember(AdmissionCommiteeMember member);

	AdmissionCommiteeMember updateCommitteeMember(AdmissionCommiteeMember member);

	AdmissionCommiteeMember viewCommitteeMember(int id);

	void removeCommitteeMember(int id);

	List<AdmissionCommiteeMember> viewAllCommitteeMembers();

	AdmissionStatus provideAdmissionResult(Applicant applicant, Admission admission);

}
