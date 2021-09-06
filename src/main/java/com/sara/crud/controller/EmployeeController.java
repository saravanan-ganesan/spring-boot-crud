package com.sara.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sara.crud.dto.EmployeeDto;
import com.sara.crud.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
    private EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employee) {
        return employeeService.addEmployee(employee);
    }
	
	@PostMapping("/addEmployees")
    public List<EmployeeDto> addEmployees(@RequestBody List<EmployeeDto> employeeList) {
        return employeeService.addEmployees(employeeList);
    }
	
	@GetMapping("/getEmployees")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
	
	@GetMapping("/getEmployee/{name}")
    public List<EmployeeDto> getEmployeeByName(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);
    }
	
	@GetMapping("/getEmployee")
    public EmployeeDto getEmployeeById(@RequestParam(name = "id") Long id) {
        return employeeService.getEmployeeById(id);
    }
	
	@PutMapping("/updateEmployee")
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employee) {
        return employeeService.updateEmployee(employee);
    }
	
	@DeleteMapping("/deleteEmployee")
    public void deleteEmployeeById(@RequestParam(name = "id") Long id) {
        employeeService.deleteEmployeeById(id);
    }
	

}
