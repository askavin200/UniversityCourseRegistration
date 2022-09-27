package com.capgemini.UniversityCourseSelection.repo;

import com.capgemini.UniversityCourseSelection.entities.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {

}
