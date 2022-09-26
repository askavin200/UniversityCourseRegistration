package com.capgemini.UniversityCourseSelection.entites;

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
	
	private String applicantName;
	private long mobileNumber;
	private String applicantDegree;
	private double GraduationPassword;
	
	private String password; //added field
	
	private AdmissionStatus status;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Admission admission;
	

}
