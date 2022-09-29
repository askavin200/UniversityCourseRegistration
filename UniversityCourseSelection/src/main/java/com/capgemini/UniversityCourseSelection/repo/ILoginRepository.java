package com.capgemini.UniversityCourseSelection.repo;

public interface ILoginRepository {
	
	
	boolean verifyApplicantCredentials(int id,String password);
	boolean verifyAdmissionCommiteeMemberCredentials(int id,String password);
	boolean verifyUniversityStaffMemberCredentials(int id,String password);

}
