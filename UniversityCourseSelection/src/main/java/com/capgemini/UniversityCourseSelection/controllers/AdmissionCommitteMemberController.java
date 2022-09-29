package com.capgemini.UniversityCourseSelection.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.UniversityCourseSelection.entities.Admission;
import com.capgemini.UniversityCourseSelection.entities.AdmissionCommiteeMember;
import com.capgemini.UniversityCourseSelection.entities.AdmissionStatus;
import com.capgemini.UniversityCourseSelection.entities.Applicant;
import com.capgemini.UniversityCourseSelection.services.IAdmissionCommiteeMemberService;

@RestController
@RequestMapping("/uni/committee")
public class AdmissionCommitteMemberController {

	@Autowired
	private IAdmissionCommiteeMemberService committeService;

	@PostMapping("/add")
	public ResponseEntity<AdmissionCommiteeMember> addAddmissionCommitteeMember(
			@RequestBody AdmissionCommiteeMember member) {
		AdmissionCommiteeMember mem = null;
		mem = committeService.addCommitteeMember(member);
		return new ResponseEntity<>(mem, null, HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<AdmissionCommiteeMember> updateCommitteeMember(@RequestBody AdmissionCommiteeMember member) {
		AdmissionCommiteeMember mem = null;
		mem = committeService.updateCommitteeMember(member);
		return new ResponseEntity<>(mem, null, HttpStatus.OK);
	}

	@GetMapping("/view/{id}")
	public ResponseEntity<AdmissionCommiteeMember> viewCommitteeMemberById(@PathVariable int id) {
		AdmissionCommiteeMember member = null;
		member = committeService.viewCommitteeMember(id);
		return new ResponseEntity<>(member, null, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCommitteeMember(@PathVariable int id) {
		try {
			committeService.removeCommitteeMember(id);
		} catch (Exception e) {
			return new ResponseEntity<>("Commitee Member with id: " + id + " not found! ", null, HttpStatus.OK);
		}
		return new ResponseEntity<>("Commitee member deleted successfully!", null, HttpStatus.OK);
	}

	@GetMapping("/viewAll")
	public ResponseEntity<List<AdmissionCommiteeMember>> viewAllCommiteeMembers() {
		List<AdmissionCommiteeMember> l = committeService.viewAllCommitteeMembers();
		return new ResponseEntity<>(l, null, HttpStatus.OK);
	}

	@PostMapping("/getResult")
	public ResponseEntity<AdmissionStatus> getAdmissionResult(@RequestBody Applicant applicant,
			@RequestBody Admission admission) {

		AdmissionStatus status = null;
		status = committeService.provideAdmissionResult(applicant, admission);
		return new ResponseEntity<>(status, null, HttpStatus.OK);
	}

}
