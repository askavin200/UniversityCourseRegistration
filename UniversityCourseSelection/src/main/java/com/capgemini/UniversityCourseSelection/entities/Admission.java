package com.capgemini.UniversityCourseSelection.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admission_details")
public class Admission {	
	
	@Id
	@Column(name = "admission_id")
	@SequenceGenerator(
			name = "admission_id_sequence",
			sequenceName = "admission_id_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "admission_id_sequence")
	private int admissionId;
	
	@Column(name = "course_id")
	private int courseId;
	
//	@Column(name = "applicant_id")
//	private int applicantId;
	
	@Column(name = "admission_date")
	@JsonFormat(pattern="dd-MMM-yyyy")
	private LocalDate admissionDate;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "admission")
	private Applicant applicant;

}
