package com.capgemini.UniversityCourseSelection.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import com.capgemini.UniversityCourseSelection.entities.UniversityStaffMember;
import com.capgemini.UniversityCourseSelection.repo.IUniversityStaffMemberRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UniversityStaffServiceImplTest {
	
	@Mock
	private IUniversityStaffMemberRepository staffRepo;
	@InjectMocks
	private UniversityStaffServiceImpl staffService;
	
	UniversityStaffMember STAFF_1 = new UniversityStaffMember(1,"password1","role1");
	UniversityStaffMember STAFF_2 = new UniversityStaffMember(2,"password2","role2");
	UniversityStaffMember STAFF_3 = new UniversityStaffMember(3,"password3","role3");
	
//	@BeforeEach
//	void initMethod() {
//		MockitoAnnotations.initMocks(this);
//	}
	
//	@Test
//	void testAddStaff_success() {
//		UniversityStaffMember newStaff = new UniversityStaffMember(4,"password4","role4");
//		Mockito.when(staffRepo.save(newStaff)).thenReturn(newStaff);
////		assertEquals(4,staffService.addStaff(newStaff).getStaffId());
////		assertEquals("password4",staffService.addStaff(newStaff).getPassword());
////		assertEquals("role4",staffService.addStaff(newStaff).getRole());
//		assertEquals(newStaff, staffService.addStaff(newStaff));
//	}

	@Test
	void testUpdateStaff_success() {
		UniversityStaffMember updateStaff = new UniversityStaffMember(1,"new_pwd","new_role");
		Mockito.when(staffRepo.existsById(updateStaff.getStaffId())).thenReturn(true);
		Mockito.when(staffRepo.save(updateStaff)).thenReturn(updateStaff);
		assertEquals("new_pwd",staffService.updateStaff(updateStaff).getPassword());
	}

	@Test
	void testViewStaff_success() {
		Mockito.when(staffRepo.getReferenceById(STAFF_1.getStaffId())).thenReturn(STAFF_1);
		assertNotNull(staffService.viewStaff(1));
	}

	@Test
	void testRemoveStaff_success() {
		Mockito.when(staffRepo.existsById(1)).thenReturn(true);
		boolean success = true;
		try {
			staffService.removeStaff(1);
		} catch (Exception e) {
			success = false;
		}
		assertEquals(true, success);
	}

	@Test
	void testViewAllStaffs_success() {
		List<UniversityStaffMember> allStaff = new ArrayList<>(Arrays.asList(STAFF_1,STAFF_2,STAFF_3));
		Mockito.when(staffRepo.findAll()).thenReturn(allStaff);
		assertEquals(3, staffService.viewAllStaffs().size());
		assertEquals("password2", staffService.viewAllStaffs().get(1).getPassword());
		assertEquals("role3", staffService.viewAllStaffs().get(2).getRole());
	}

}
