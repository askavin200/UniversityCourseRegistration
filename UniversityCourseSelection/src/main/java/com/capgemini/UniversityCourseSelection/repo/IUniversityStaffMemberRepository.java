package com.capgemini.UniversityCourseSelection.repo;

import com.capgemini.UniversityCourseSelection.entities.UniversityStaffMember;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUniversityStaffMemberRepository extends JpaRepository<UniversityStaffMember, Integer> {

}

