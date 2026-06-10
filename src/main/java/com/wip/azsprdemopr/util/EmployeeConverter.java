package com.wip.azsprdemopr.util;

import com.wip.azsprdemopr.dto.EmployeeDto;
import com.wip.azsprdemopr.entity.Employee;

public class EmployeeConverter {

	public static EmployeeDto toDto(Employee employee) {
		EmployeeDto dto = new EmployeeDto();
		dto.setEid(employee.getEid());
		dto.setEname(employee.getEname());
		dto.setEmail(employee.getEmail());
		dto.setDob(employee.getDob());

		return dto;
	}

	public static Employee toEntity(EmployeeDto dto) {
		Employee employee = new Employee();

		employee.setEname(dto.getEname());
		employee.setEmail(dto.getEmail());
		employee.setDob(dto.getDob());
		return employee;
	}

}
