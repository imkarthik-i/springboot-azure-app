package com.wip.azsprdemopr.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eid;

	private String ename;
	private String email;
	private LocalDate dob;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long eid, String ename, String email, LocalDate dob) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.email = email;
		this.dob = dob;
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", email=" + email + ", dob=" + dob + "]";
	}

}
