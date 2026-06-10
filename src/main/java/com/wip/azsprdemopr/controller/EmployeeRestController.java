package com.wip.azsprdemopr.controller;

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

import com.wip.azsprdemopr.dto.EmployeeDto;
import com.wip.azsprdemopr.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public String sayHi() {
		return "Hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii";
	}
	
	
	@PostMapping("/addEmp")
	public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeDto employeeDto){
		employeeService.createEmployee(employeeDto);	
		
		
		return new ResponseEntity<>("Employee " + employeeDto.getEname() + " created Successfully",HttpStatus.OK);
		
	}
	
	
	@GetMapping("/listAll")
	public ResponseEntity<List<EmployeeDto>> listAllEmployees(){
		List<EmployeeDto> empList=	employeeService.getAllEmployees();	
		return new ResponseEntity<>(empList,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAEmp/{id}")
	public ResponseEntity<EmployeeDto> getAnEmployee(@PathVariable Long id ){
		EmployeeDto emp=	employeeService.getAnEmployee(id);
				
		return new ResponseEntity<EmployeeDto>(emp,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateEmp")
	public ResponseEntity<List<EmployeeDto>> updateEmployees(@Valid @RequestBody EmployeeDto employeeDto){
		List<EmployeeDto> empList=	employeeService.updateEmployee(employeeDto);				
		return new ResponseEntity<List<EmployeeDto>>(empList,HttpStatus.OK);		
	}

	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<List<EmployeeDto>> deleteEmployees(@PathVariable Long id ){
		List<EmployeeDto> empList=	employeeService.deleteEmployee(id);		
		return new ResponseEntity<List<EmployeeDto>>(empList,HttpStatus.OK);		
	}
	
	@GetMapping("/getEmpByName/{name}")
	public ResponseEntity<EmployeeDto> searchByName(@PathVariable String name ){
		EmployeeDto emp=	employeeService.searchByEname(name);				
		return new ResponseEntity<EmployeeDto>(emp,HttpStatus.OK);
		
	}
	
}
