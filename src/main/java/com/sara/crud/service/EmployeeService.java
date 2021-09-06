package com.sara.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sara.crud.dto.EmployeeDto;

@Service
public interface EmployeeService {

	//Add Employee	
	public EmployeeDto addEmployee(EmployeeDto employee);
	
	public List<EmployeeDto> addEmployees(List<EmployeeDto> employee);
	
	//Get Employee
	public List<EmployeeDto> getAllEmployees();
	
	public List<EmployeeDto> getEmployeeByName(String name);
	
	public EmployeeDto getEmployeeById(Long id);
	
	//Update Employee
	public EmployeeDto updateEmployee(EmployeeDto employee);
	
	//Delete Employee
	public void deleteEmployeeById(Long id);
}
