package com.ems.rest.HateOasApplication.service;

import java.util.List;

import com.ems.rest.HateOasApplication.pojo.Employee;

public interface ServiceInterface {

	public void addNewEmployee(Employee emp);
	public List<Employee> viewAllEmployee();
	public void deleteEmployee(int empId);
	public void updateEmployee(Employee emp);
	public Employee searchEmployee(int empId);
}
