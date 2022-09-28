package com.capgemini.UniversityCourseSelection.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course {
	@Id
	@Column(name = "course_Id")
	@SequenceGenerator(
			name = "course_sequence",
			sequenceName = "course_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "course_sequence")
	private int courseId;
	
	@Column(name = "course_Name")
	private String courseName;
	
	@Column(name = "course_Duration")
	private String courseDuration;
	
	@Column(name = "course_StartDate")
	@JsonFormat(pattern="dd-MMM-yyyy")
	private LocalDate courseStartDate;
	
	@Column(name = "course_EndDate")
	@JsonFormat(pattern="dd-MMM-yyyy")
	private LocalDate courseEndDate;
	
	@Column(name = "course_Fees")
	private String courseFees;
	
	@Column(name = "course_Criteria")
	private double courseCriteria;

}
