package com.capgemini.UniversityCourseSelection.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
<<<<<<< HEAD
=======
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
>>>>>>> branch 'main' of git@github.com:raf2723/UniversityCourseRegistration.git
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admission_committee_member")
public class AdmissionCommiteeMember {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	@Id
	private int adminId;
	
	@Column(name = "admin_name")
	private String adminName;
	
	@Column(name = "admin_contact")
	private String adminContact;
	
	@Column(name = "admin_username")
	private String adminUsername;
	
	@Column(name = "admin_password")
	private String adminPassword;

	public AdmissionCommiteeMember() {
		super();
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

}
