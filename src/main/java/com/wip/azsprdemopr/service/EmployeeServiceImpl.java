package com.wip.azsprdemopr.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wip.azsprdemopr.dto.EmployeeDto;
import com.wip.azsprdemopr.entity.Employee;
import com.wip.azsprdemopr.exception.EmployeeNotFoundException;
import com.wip.azsprdemopr.repository.EmployeeRepository;
import com.wip.azsprdemopr.util.EmployeeConverter;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	
	
	@Override
	public void createEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeConverter.toEntity(employeeDto);
		
		employeeRepository.save(employee);
		System.out.println("Employee Created ...");
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> empList = employeeRepository.findAll();
		System.out.println(empList);
		return empList.stream().map(EmployeeConverter::toDto).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto getAnEmployee(Long id) {
		Employee emp =  employeeRepository.findById(id)
				.orElseThrow(()->new EmployeeNotFoundException("Employee","eid",id));
		return EmployeeConverter.toDto(emp);
	}

	@Override
	public List<EmployeeDto> updateEmployee(EmployeeDto employeeDto) {
		System.out.println("888888888888888888888" + employeeDto);
		
		Employee employee = employeeRepository.findById(employeeDto.getEid())
				.orElseThrow(()->new EmployeeNotFoundException("Employee","eid",employeeDto.getEid()));
		
		employee.setEname(employeeDto.getEname());
		employee.setEmail(employeeDto.getEmail());
		employee.setDob(employeeDto.getDob());
		employeeRepository.save(employee);
		return getAllEmployees();
	}

	@Override
	public List<EmployeeDto> deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		return getAllEmployees();
	}

	@Override
	public EmployeeDto searchByEname(String ename) {
		Employee emp =  employeeRepository.findByEname(ename)
				.orElseThrow(()->new EmployeeNotFoundException("Employee","ename",ename));
		return EmployeeConverter.toDto(emp);
		
	}

}
