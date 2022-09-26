package com.capgemini.UniversityCourseSelection.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseId;
	private String courseName;
	private String courseDuration;
	private LocalDate courseStartDate;
	private LocalDate courseEndDate;
	private String courseFees;
}
