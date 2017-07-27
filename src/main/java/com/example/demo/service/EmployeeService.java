package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployee(int empId);
	
	public void deleteEmployee(int empId);
	
	public void addEmployee(Employee employee);
	
	public void addEmployee(List<Employee> employees);
	
	public List<Employee> searchEmpsByCriteria(String firstName, String lastName);

}
