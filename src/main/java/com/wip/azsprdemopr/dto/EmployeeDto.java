package com.wip.azsprdemopr.dto;

import java.time.LocalDate;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class EmployeeDto {

	private Long eid;

	@NotBlank(message = "Employee name cannot be empty")
	@Size(min = 2, max = 30, message = "Name Must contain 3 to 30 character")
	private String ename;

	@NotBlank(message = "Employee Email cannot be empty")
	@Email(message = "Invalid Email format")
	private String email;

	@NotNull(message = "DOB cannot be null")
	@Past(message = "DOB must be the past date")
	private LocalDate dob;

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDto(Long eid, String ename, String email, LocalDate dob) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.email = email;
		this.dob = dob;
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

	@Override
	public String toString() {
		return "EmployeeDto [eid=" + eid + ", ename=" + ename + ", email=" + email + ", dob=" + dob + "]";
	}

}
