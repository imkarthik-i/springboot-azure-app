package com.wip.azsprdemopr.service;

import java.util.List;
import java.util.Optional;

import com.wip.azsprdemopr.dto.EmployeeDto;
import com.wip.azsprdemopr.entity.Employee;

public interface EmployeeService {
	
	public void createEmployee(EmployeeDto employeeDto);
	public List<EmployeeDto> getAllEmployees();
	public EmployeeDto getAnEmployee(Long id);
	public List<EmployeeDto> updateEmployee(EmployeeDto employeeDto);
	public List<EmployeeDto> deleteEmployee(Long id);
	public EmployeeDto searchByEname(String ename);
	
	
}
