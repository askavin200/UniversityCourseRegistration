package com.capgemini.UniversityCourseSelection.repo;

import com.capgemini.UniversityCourseSelection.entities.UniversityStaffMember;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUniversityStaffMemberRepository extends JpaRepository<UniversityStaffMember, Integer> {

}

