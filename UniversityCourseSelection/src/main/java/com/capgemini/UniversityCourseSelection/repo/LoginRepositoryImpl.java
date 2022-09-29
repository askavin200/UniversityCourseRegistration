package com.capgemini.UniversityCourseSelection.repo;

import com.capgemini.UniversityCourseSelection.entities.AdmissionCommiteeMember;
import com.capgemini.UniversityCourseSelection.entities.Applicant;
import com.capgemini.UniversityCourseSelection.entities.UniversityStaffMember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class LoginRepositoryImpl implements ILoginRepository {
	
	
	@Autowired
	private IApplicantRepository appRepo;
	
	@Autowired
	private IAdmissionCommiteeMemberRepository addRepo;
	
	@Autowired
	private IUniversityStaffMemberRepository uniRepo;

	@Override
	public boolean verifyApplicantCredentials(int id, String password) {
		Applicant app = appRepo.verifyApplicantCredentials(id, password);
		if(app!=null)
			return true;
		else return false;
	}

	@Override
	public boolean verifyAdmissionCommiteeMemberCredentials(int id, String password) {
		AdmissionCommiteeMember acm= addRepo.verifyAdmissionCommiteeMemberCred(id, password);
		if(acm!=null)
			return true;
		return false;
	}

	@Override
	public boolean verifyUniversityStaffMemberCredentials(int id, String password) {
		UniversityStaffMember ucm=uniRepo.verifyUniversityStaffMemberCredentials(id, password);
		if(ucm!=null) {
			return true;
		}
		return false;
	}

}
