package com.capgemini.UniversityCourseSelection.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.UniversityCourseSelection.entities.Course;


@Repository
public interface ICourseRepo extends JpaRepository<Course, Integer> {

}
