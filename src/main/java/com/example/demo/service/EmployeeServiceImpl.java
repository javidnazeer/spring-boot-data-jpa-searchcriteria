package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeSpecifications;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRep;

	@Override
	public List<Employee> getAllEmployees() {
		return empRep.findAll();
	}

	@Override
	public Employee getEmployee(int empId) {
		return empRep.findOne(empId);
	}

	@Override
	public void deleteEmployee(int empId) {
		empRep.delete(empId);

	}

	@Override
	public void addEmployee(Employee employee) {
		empRep.save(employee);
	}

	@Override
	public void addEmployee(List<Employee> employees) {
		empRep.save(employees);
	}

	@Override
	public List<Employee> searchEmpsByCriteria(String firstName, String lastName) {
		List<Employee> employees = empRep.findAll(EmployeeSpecifications.filterByFirstNameAndZip(firstName, lastName));
		return employees;
	}

}
