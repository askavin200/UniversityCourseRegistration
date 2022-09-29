package com.capgemini.UniversityCourseSelection.services;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capgemini.UniversityCourseSelection.entities.AdmissionCommiteeMember;
import com.capgemini.UniversityCourseSelection.exception.NotFoundException;
import com.capgemini.UniversityCourseSelection.repo.IAdmissionCommiteeMemberRepository;

@ExtendWith(MockitoExtension.class)
class AdmissionCommitteeMemberServiceImplTest {

	@Mock
	private IAdmissionCommiteeMemberRepository repo;
	
	@InjectMocks
	private AdmissionCommitteeMemberServiceImpl service;
	
	public AdmissionCommiteeMember mem = new AdmissionCommiteeMember(1,"adesh","1234123412","amedhe","pass");

	
	@Test
	public void testAddCommitteeMember_success()
	{
		Mockito.when(repo.save(mem)).thenReturn(mem);
		assertEquals(mem, service.addCommitteeMember(mem));
	}
	
	@Test
	public void testUpdateCommitteeMember_success()
	{
		Mockito.when(repo.save(mem)).thenReturn(mem);
		Mockito.when(repo.existsById(mem.getAdminId())).thenReturn(true);
		assertEquals(mem, service.updateCommitteeMember(mem));
	}
	
	@Test
	public void testViewCommitteeMember_success()
	{
		Mockito.when(repo.existsById(mem.getAdminId())).thenReturn(true);
		Mockito.when(repo.findById(mem.getAdminId())).thenReturn(Optional.ofNullable(mem));
		assertEquals(mem, service.viewCommitteeMember(1));
	}
	
	@Test
	public void testRemoveCommitteeMember_success()
	{
		Mockito.when(repo.existsById(mem.getAdminId())).thenReturn(true);
		boolean success = true;
		try {
			service.removeCommitteeMember(1);
		}catch(Exception e)
		{
			success = false;
		}
		assertEquals(true,success);
	}
	
	
	@Test
	public void testAddCommitteeMember_failure()
	{
		Mockito.when(repo.save(mem)).thenThrow(new IllegalArgumentException());
		assertThrows(IllegalArgumentException.class, () -> {
			service.addCommitteeMember(mem);
		});
	}
	
	@Test
	public void testUpdateCommitteeMember_failureWhenNull()
	{
		Mockito.when(repo.existsById(mem.getAdminId())).thenThrow(new IllegalArgumentException());
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateCommitteeMember(mem);
		});
	}
	
	@Test
	public void testUpdateCommitteeMember_failureWhenNotFound()
	{
		Mockito.when(repo.existsById(mem.getAdminId())).thenReturn(false);
		assertThrows(NotFoundException.class, () -> {
			service.updateCommitteeMember(mem);
		});
	}
	
	@Test
	public void testViewCommitteeMember_failureWhenNotFound()
	{
		Mockito.when(repo.existsById(1)).thenReturn(false);
		assertThrows(NotFoundException.class, () -> {
			service.viewCommitteeMember(1);
		});
	}

	@Test
	public void testRemoveCommitteeMember_failureWhenNotFound()
	{
		Mockito.when(repo.existsById(1)).thenReturn(false);
		assertThrows(NotFoundException.class, () -> {
			service.removeCommitteeMember(1);
		});
	}
}
