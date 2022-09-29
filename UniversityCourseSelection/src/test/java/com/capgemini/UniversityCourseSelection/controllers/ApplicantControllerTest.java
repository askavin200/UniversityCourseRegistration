package com.capgemini.UniversityCourseSelection.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import com.capgemini.UniversityCourseSelection.entities.Admission;
import com.capgemini.UniversityCourseSelection.entities.AdmissionStatus;
import com.capgemini.UniversityCourseSelection.entities.Applicant;
import com.capgemini.UniversityCourseSelection.entities.UniversityStaffMember;
import com.capgemini.UniversityCourseSelection.services.ApplicantServiceImpl;
import com.capgemini.UniversityCourseSelection.services.IApplicantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@ExtendWith(MockitoExtension.class)
class ApplicantControllerTest {
	
	private MockMvc mvc;
	
	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();
	
	@Mock
	private IApplicantService service;
	
	@InjectMocks
	private ApplicantController control;
	

	@BeforeEach
	void setup() {
		this.mvc = MockMvcBuilders.standaloneSetup(control).build();
	}

	static Applicant app1 = new Applicant(1,"john",9000,"grad",90.1,"pass",new Admission());
//	static Admission add1=new Admission();
	static Applicant app2 = new Applicant();
	static Applicant app3 = new Applicant();
	
	@BeforeAll
	static void initMethod() {
//		app1.setApplicantId(1);	
		app1.getAdmission().setAdmissionId(1);
		app1.setStatus(AdmissionStatus.APPLIED);
		app1.getAdmission().setApplicantId(1);
		app1.getAdmission().setCourseId(10);
//		app1.getAdmission().setAdmissionDate(LocalDate.of(2022, 9, 2));
////	app1.setAdmission(add1);
		app2.setApplicantId(2);
		app2.setAdmission(new Admission());
		app3.setApplicantId(3);
		app3.setAdmission(new Admission());
		app3.setStatus(AdmissionStatus.CONFIRMED);

	}
	
//	@Test
//	void testApplyForCourse() throws Exception {
//		Mockito.when(service.addApplicant(app1)).thenReturn(app1);
//		
//		String body=objectWriter.writeValueAsString(app1);
//		
//		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/applicant/apply")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON)
//				.content(body);
//		mvc.perform(mockRequest)
//		.andExpect(status().isOk());
//		
//	}
	@Test
	void updateStaff_success() throws Exception {
		Applicant app4=new Applicant();
		
		Mockito.when(service.updateApplicant(app4)).thenReturn(app4);
		
		String updatedBody = objectWriter.writeValueAsString(app4);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/applicant/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(updatedBody)
				.accept(MediaType.APPLICATION_JSON);
		
		mvc.perform(mockRequest)
		.andExpect(status().isOk());
//		.andExpect(jsonPath("$", notNullValue()))
//		.andExpect(jsonPath("$.password", is("new_pwd")))
//		.andExpect(jsonPath("$.role", is("new_role")));
	}


}
