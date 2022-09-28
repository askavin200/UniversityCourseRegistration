package com.capgemini.UniversityCourseSelection.services;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.UniversityCourseSelection.entities.Admission;
import com.capgemini.UniversityCourseSelection.repo.IAdmissionRepository;

@Component
public class AdmissionServiceImpl implements IAdmissionService {
	
	@Autowired
	private IAdmissionRepository admissionrepo;
	
	@Override
	public Admission addAdmission(Admission add) {
		Admission addadmission = add;
		return admissionrepo.save(addadmission);
		
	}

	@Override
	public Admission cancelAdmission(int admissionId) {
		Admission deletedadmission = null;
		if(admissionrepo.existsById(admissionId)) {
			deletedadmission = admissionrepo.findById(admissionId).get();
			admissionrepo.deleteById(admissionId);
			return deletedadmission;
		}	
		return deletedadmission;	
	}

	@Override
	public Admission updateAdmission(Admission add) {
		Admission updatedadmission = null;
		if(admissionrepo.existsById(add.getCourseId())) 
			updatedadmission = admissionrepo.save(add);
		return updatedadmission;
	}	

	@Override
	public List<Admission> showAllAdmissionByCourseId(int courseId) {
		List<Admission> admissionlist = admissionrepo.findAllAdmissionByCourseId(courseId);	
		return admissionlist;
	}

	@Override
	public List<Admission> showAllAdmissionbyDate(LocalDate date) {
		List<Admission> admissionlist = admissionrepo.findAllAdmissionByAdmissionDate(date);	
		return admissionlist;	
	}

}

