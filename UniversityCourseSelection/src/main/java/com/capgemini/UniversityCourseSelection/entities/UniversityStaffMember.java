package com.capgemini.UniversityCourseSelection.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UniversityStaffMember {
	
	//comment for cheking git integration
	
	@Id
	@Column(name = "staff_Id")
	@SequenceGenerator(
			name = "staff_sequence",
			sequenceName = "staff_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "staff_sequence")
	private Integer staffId;
	private String password;
	private String role;
}
