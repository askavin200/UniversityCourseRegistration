package com.capgemini.UniversityCourseSelection.repo;

import com.capgemini.UniversityCourseSelection.entities.UniversityStaffMember;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUniversityStaffMemberRepository extends JpaRepository<UniversityStaffMember, Integer> {
	
	
	@Query(value="select * from university_staff_member where staff_id=?1 and password=?2",nativeQuery = true)
	UniversityStaffMember verifyUniversityStaffMemberCredentials(int id,String password);

}

