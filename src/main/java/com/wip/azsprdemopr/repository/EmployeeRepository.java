package com.wip.azsprdemopr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wip.azsprdemopr.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	public Optional<Employee> findByEname(String ename);
}
