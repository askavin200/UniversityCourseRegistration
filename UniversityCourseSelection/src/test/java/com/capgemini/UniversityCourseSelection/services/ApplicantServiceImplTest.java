package com.capgemini.UniversityCourseSelection.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Optional;

import com.capgemini.UniversityCourseSelection.entities.Admission;
import com.capgemini.UniversityCourseSelection.entities.AdmissionStatus;
import com.capgemini.UniversityCourseSelection.entities.Applicant;
import com.capgemini.UniversityCourseSelection.repo.IApplicantRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ApplicantServiceImplTest {

	@Mock
	private IApplicantRepository apprepo;

	@InjectMocks
	private ApplicantServiceImpl appservice;

	static Applicant app1 = new Applicant();
	static Applicant app2 = new Applicant();
	static Applicant app3 = new Applicant();

	@BeforeAll
	static void initMethod() {
		app1.setApplicantId(1);
		app1.setAdmission(new Admission());
		app2.setApplicantId(2);
		app2.setAdmission(new Admission());
		app3.setApplicantId(3);
		app3.setAdmission(new Admission());
		app3.setStatus(AdmissionStatus.CONFIRMED);

	}

	@Test
	void testAddApplicant_success() {
		Mockito.when(apprepo.save(app1)).thenReturn(app1);
		
		

		assertEquals(app1, appservice.addApplicant(app1));
	}

	@Test
	void testUpdateApplicant_success() {
		Mockito.when(apprepo.save(app2)).thenReturn(app2);
		assertEquals(app2, appservice.updateApplicant(app2));
	}

	@Test
	void testDeleteApplicant_success() {
//		Mockito.when(apprepo.existsById(1)).thenReturn(true);
		boolean success = true;
		try {
			appservice.deleteApplicant(app1);
		} catch (Exception e) {
			success = false;
		}
		assertEquals(true, success);
	}

	@Test
	void testViewApplicant_success() {
		Mockito.when(apprepo.findById(1)).thenReturn(Optional.ofNullable(app1));
		assertTrue(appservice.viewApplicant(1).isPresent());

	}

	@Test
	void testViewAllApplicantsByStatus_success() {
		List<Applicant> applied = new ArrayList<>();
		applied.add(app1);
		applied.add(app2);
		List<Applicant> confirmed = new ArrayList<>();
		confirmed.add(app3);

		Mockito.when(apprepo.viewAllApplicantByCourse(AdmissionStatus.APPLIED)).thenReturn(applied);
		Mockito.when(apprepo.viewAllApplicantByCourse(AdmissionStatus.CONFIRMED)).thenReturn(confirmed);

		assertEquals(applied, appservice.viewAllApplicantsByStatus(AdmissionStatus.APPLIED));
		assertEquals(confirmed, appservice.viewAllApplicantsByStatus(AdmissionStatus.CONFIRMED));
	}

	@Test
	void testAddApplicant_failure() {
		Mockito.when(apprepo.save(app3)).thenThrow(new IllegalArgumentException());

		assertThrows(IllegalArgumentException.class, () -> {
			appservice.addApplicant(app3);
		});
	}

	@Test
	void testUpdateApplicant_failure() {
		Mockito.when(apprepo.save(app3)).thenThrow(new IllegalArgumentException());

		assertThrows(IllegalArgumentException.class, () -> {
			appservice.addApplicant(app3);
		});
	}
	
	@Test
	void testViewApplicant_failure() {
		Applicant app4=null;
		Mockito.when(apprepo.findById(4)).thenReturn(Optional.ofNullable(app4));
		assertTrue(appservice.viewApplicant(4).isEmpty());
	}
	
	@Test
	void testViewAllApplicantsByStatus_failure() {
		List<Applicant> list=null;
		Mockito.when(apprepo.viewAllApplicantByCourse(AdmissionStatus.REJECTED)).thenReturn(list);
		assertEquals(list, appservice.viewAllApplicantsByStatus(AdmissionStatus.REJECTED));
	}

}
