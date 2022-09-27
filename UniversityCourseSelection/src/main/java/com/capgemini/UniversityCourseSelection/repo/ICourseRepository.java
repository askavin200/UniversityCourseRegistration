package com.capgemini.UniversityCourseSelection.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.UniversityCourseSelection.entites.Course;


@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {

}
