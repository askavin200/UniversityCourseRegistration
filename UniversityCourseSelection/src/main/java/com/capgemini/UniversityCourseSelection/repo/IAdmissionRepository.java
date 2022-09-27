package com.capgemini.UniversityCourseSelection.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.UniversityCourseSelection.entities.Admission;

@Repository
public interface IAdmissionRepository extends JpaRepository<Admission,Integer> {

}

