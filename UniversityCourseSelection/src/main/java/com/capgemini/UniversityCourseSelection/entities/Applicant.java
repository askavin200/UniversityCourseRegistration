package com.capgemini.UniversityCourseSelection.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Applicant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer applicantId;
	
	
	@Column(name = "name")
	private String applicantName;
	
	@Column(name="mobile_number")
	private long mobileNumber;
	
	@Column(name="Degree")
	private String applicantDegree;
	
	@Column(name="grad_percentage")
	private double applicantGraduationPercentage;
	
	private String password; //added field
	
	private AdmissionStatus status;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Admission admission;
	

}
