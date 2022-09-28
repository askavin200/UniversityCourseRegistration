package com.capgemini.UniversityCourseSelection.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.UniversityCourseSelection.entities.Admission;
import com.capgemini.UniversityCourseSelection.services.IAdmissionService;

@RestController
@RequestMapping("/admission")
public class AdmissionController {
	
	@Autowired
	public IAdmissionService service;
	
	
	@PostMapping("/addAdmission")
	public ResponseEntity<Admission> addAdmission(@RequestBody Admission admission) {
		Admission ref = service.addAdmission(admission);
		return new ResponseEntity<>(ref,HttpStatus.OK);	
	}
	
	
	@PutMapping("/updateAdmission")
    public ResponseEntity<Admission> updateAdmission(@RequestBody Admission admission){
		Admission ref = service.updateAdmission(admission);
		return new ResponseEntity<>(ref,HttpStatus.OK);
	} 
    
	
	@DeleteMapping("/cancelAdmission/{admissionId}")
    public ResponseEntity<Admission> cancelAdmission(@PathVariable int admissionId){
		Admission ref = service.cancelAdmission(admissionId);
		return new ResponseEntity<>(ref,HttpStatus.OK);
	} 
    
	
	@GetMapping("/alladmissionbyId/{courseId}")
    public ResponseEntity<List<Admission>> showAllAdmissionByCourseId(@PathVariable int courseId ){
		List<Admission> ref = service.showAllAdmissionByCourseId(courseId);
		return new ResponseEntity<>(ref,HttpStatus.OK);
	} 
    
	
	
	@GetMapping("/alladmissionby/{date}")
    public ResponseEntity<List<Admission>> showAdmissionByDate(@PathVariable LocalDate date){
		List<Admission> ref = service.showAllAdmissionbyDate(date);
		return new ResponseEntity<>(ref, HttpStatus.OK);
	} 
    
}