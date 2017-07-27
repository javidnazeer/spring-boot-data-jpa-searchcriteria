package com.example.demo.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping(value="employee/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
		Employee employee = empService.getEmployee(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@RequestMapping(value="employees",method=RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employee = empService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
	}
	
	@RequestMapping(value="/addEmployees", method=RequestMethod.POST)
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		empService.addEmployee(employee);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public ResponseEntity<List<Employee>> searchEmployee(@Validated @RequestBody Employee employee) {
		List<Employee> employees = empService.searchEmpsByCriteria(employee.getFirstName(), employee.getLastName());
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}

}
