package com.capgemini.UniversityCourseSelection.services;

import static org.junit.jupiter.api.Assertions.*;

import com.capgemini.UniversityCourseSelection.entities.Admission;
import com.capgemini.UniversityCourseSelection.entities.Applicant;
import com.capgemini.UniversityCourseSelection.repo.IApplicantRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ApplicantServiceImplTest {
	
	@Mock
	private IApplicantRepository apprepo;
	
	
	@InjectMocks
	private ApplicantServiceImpl appservice;
	
	Applicant app1=new Applicant();
	Applicant app2=new Applicant();
	Applicant app3=new Applicant();
	
	@Test
	void testAddApplicant_Success() {
		app1.setAdmission(new Admission());
		app1.setApplicantId(1);
		Mockito.when(apprepo.save(app1)).thenReturn(app1);
		
		assertEquals(app1, appservice.addApplicant(app1));
	}
	
	@Test
	void testUpdateApplicant() {
		Mockito.when(apprepo.save(app2)).thenReturn(app2);
		assertEquals(app2,appservice.updateApplicant(app2));
	}
	
	
	@Test
	void testDeleteApplicant() {
		
	}
	
	
  

}
