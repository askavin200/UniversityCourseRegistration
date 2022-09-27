package com.capgemini.UniversityCourseSelection.services;

import java.util.List;

import com.capgemini.UniversityCourseSelection.entities.Admission;
import com.capgemini.UniversityCourseSelection.entities.AdmissionCommiteeMember;
import com.capgemini.UniversityCourseSelection.entities.AdmissionStatus;
import com.capgemini.UniversityCourseSelection.entities.Applicant;

public interface IAdmissionCommiteeMemberService {

	AdmissionCommiteeMember addCommitteeMember(AdmissionCommiteeMember member);

	AdmissionCommiteeMember updateCommitteeMember(AdmissionCommiteeMember member);

	AdmissionCommiteeMember viewCommitteeMember(int id);

	void removeCommitteeMember(int id);

	List<AdmissionCommiteeMember> viewAllCommitteeMembers();

	AdmissionStatus provideAdmissionResult(Applicant applicant, Admission admission);

}
