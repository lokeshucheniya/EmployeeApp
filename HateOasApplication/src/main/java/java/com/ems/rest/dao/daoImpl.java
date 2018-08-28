/*package com.ems.rest.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import com.ems.rest.EmployeeController;
import com.ems.rest.pojo.Employee;

public class daoImpl implements employeeDao{
	
	List<Employee> set = new ArrayList<Employee>();
	

	public void addNewEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Link link = ControllerLinkBuilder.linkTo(EmployeeController.class)
				.slash(emp.getEmpName()).withSelfRel();
		
		Link deleteLink = ControllerLinkBuilder.linkTo(EmployeeController.class)
				.slash("delete").slash(emp.getEmpId()).withSelfRel();
		
		emp.add(link, deleteLink);
		
		set.add(emp);
		
	}

	public List<Employee> viewAllEmployee() {
		// TODO Auto-generated method stub
		return set;
	}

	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		
		for (Employee emp:set) {
			if(emp.getEmpId()==empId) {
				set.remove(emp);
			}
			
		}
		
	}
	
	public Employee searchEmployee(String empName) {
		for (Employee employee : set) {
			if (employee.getEmpName().equals(empName)) {
				employee.removeLinks();
				return employee;
			}
		}
		return null;
	}

	public void updateEmployee(Employee emp) {

		for (Employee employee : set) {
			if (emp.getEmpId() == employee.getEmpId()) {
				set.remove(employee);
				set.add(emp);
			}
		}
	}

}
*/