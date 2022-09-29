package com.capgemini.UniversityCourseSelection.controllers;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.UniversityCourseSelection.entities.UniversityStaffMember;
import com.capgemini.UniversityCourseSelection.exception.NotFoundException;
import com.capgemini.UniversityCourseSelection.services.UniversityStaffServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.Arrays;

import org.hamcrest.collection.IsEmptyCollection;
import org.hibernate.hql.internal.ast.tree.IsNotNullLogicOperatorNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StaffControllerTest {
	
	private MockMvc mockMvc;
	
	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();
	
	@Mock
	private UniversityStaffServiceImpl staffService;
	
	@InjectMocks
	private StaffController staffController;
	
	@BeforeEach
	void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(staffController).build();
	}
	
	UniversityStaffMember STAFF_1 = new UniversityStaffMember(1,"password1","role1");
	UniversityStaffMember STAFF_2 = new UniversityStaffMember(2,"password2","role2");
	UniversityStaffMember STAFF_3 = new UniversityStaffMember(3,"password3","role3");
	
	@Test
	void addStaff_success() throws Exception {
		Mockito.when(staffService.addStaff(STAFF_1)).thenReturn(STAFF_1);
		
		String body = objectWriter.writeValueAsString(STAFF_1);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/uni/staff/add")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(body);
		
		mockMvc.perform(mockRequest)
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", notNullValue()))
		.andExpect(jsonPath("$.password", is("password1")))
		.andExpect(jsonPath("$.role", is("role1")));
	}

	@Test
	void updateStaff_success() throws Exception {
		UniversityStaffMember updatedStaff = new UniversityStaffMember(1,"new_pwd","new_role");
		
		Mockito.when(staffService.updateStaff(updatedStaff)).thenReturn(updatedStaff);
		
		String updatedBody = objectWriter.writeValueAsString(updatedStaff);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/uni/staff/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(updatedBody)
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(mockRequest)
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", notNullValue()))
		.andExpect(jsonPath("$.password", is("new_pwd")))
		.andExpect(jsonPath("$.role", is("new_role")));
	}
	
	@Test
	void updateStaff_failWhenNotFound() throws Exception {
		UniversityStaffMember updatedStaff = new UniversityStaffMember(5,"new_pwd","new_role");
		
		Mockito.when(staffService.updateStaff(updatedStaff))
		.thenThrow(new NotFoundException("Staff with id: "+updatedStaff.getStaffId()+" not found!"));
		
		String updatedBody = objectWriter.writeValueAsString(updatedStaff);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/uni/staff/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(updatedBody)
				.accept(MediaType.APPLICATION_JSON);
		
		assertThatThrownBy(()-> mockMvc.perform(mockRequest))
		.hasRootCause(new NotFoundException("Staff with id: "+updatedStaff.getStaffId()+" not found!"));
	}

	@Test
	void viewStaff_success() throws Exception {
		Mockito.when(staffService.viewStaff(STAFF_2.getStaffId())).thenReturn(STAFF_2);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/uni/staff/view/2")
				.contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(mockRequest)
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", notNullValue()))
		.andExpect(jsonPath("$.password", is("password2")))
		.andExpect(jsonPath("$.role", is("role2")));
	}
	
	@Test
	void viewStaff_failWhenNotFound() throws Exception {
		UniversityStaffMember viewStaff = new UniversityStaffMember(5,"password5","role5");
		Mockito.when(staffService.viewStaff(viewStaff.getStaffId()))
		.thenThrow(new NotFoundException("Staff with id: "+viewStaff.getStaffId()+" not found!"));
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/uni/staff/view/5")
				.contentType(MediaType.APPLICATION_JSON);
		
		assertThatThrownBy(()-> mockMvc.perform(mockRequest))
		.hasRootCause(new NotFoundException("Staff with id: "+viewStaff.getStaffId()+" not found!"));
	}

	@Test
	void viewAllStaffs_success() throws Exception {
		List<UniversityStaffMember> list = new ArrayList<>(Arrays.asList(STAFF_1,STAFF_2,STAFF_3));
		
		Mockito.when(staffService.viewAllStaffs()).thenReturn(list);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/uni/staff/view/all")
				.contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(mockRequest)
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", notNullValue()))
		.andExpect(jsonPath("$[1].role", is("role2")))
		.andExpect(jsonPath("$[2].password", is("password3")));
	}
	
	@Test
	void viewAllStaffs_NoRecordsFound() throws Exception {
		List<UniversityStaffMember> list = new ArrayList<>();
		
		Mockito.when(staffService.viewAllStaffs()).thenReturn(list);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/uni/staff/view/all")
				.contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(mockRequest)
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", is(list) ));
	}

	@Test
	void removeStaff_success() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/uni/staff/delete/3")
				.contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(mockRequest)
		.andExpect(status().isOk());
	}
	
	@Test
	void removeStaff_DoesNotExist() throws Exception {		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/uni/staff/delete/3")
				.contentType(MediaType.APPLICATION_JSON);
		
		assertThatThrownBy(()-> mockMvc.perform(mockRequest))
		.hasRootCause(new NotFoundException("Staff with id: 3 not found!"));
	}

}
