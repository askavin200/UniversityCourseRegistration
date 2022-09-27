package com.capgemini.UniversityCourseSelection.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.capgemini.UniversityCourseSelection.entities.Admission;
import com.capgemini.UniversityCourseSelection.repo.IAdmissionRepository;

public class AdmissionServiceImpl implements IAdmissionService {
	
	@Autowired
	private IAdmissionRepository admissionrepo;
	
	@Override
	public Admission addAdmission(Admission add) {
		Admission addadmission = add;
		return admissionrepo.save(addadmission);
		
	}

	@Override
	public Admission removeAdmission(int admissionId) {
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
	public Admission viewAdmission(int admissionId) {
		Admission admission = null;
		try {
			admission = admissionrepo.findById(admissionId).get();
		} catch (Exception e) {
		}
		
		return admission;
		
	}

	@Override
	public List<Admission> viewAllAdmission() {
		return admissionrepo.findAll() ;
	}

}
