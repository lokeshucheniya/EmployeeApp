package com.ems.rest.HateOasApplication.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.rest.HateOasApplication.exception.EmployeeNotFound;
import com.ems.rest.HateOasApplication.pojo.Employee;
import com.ems.rest.HateOasApplication.service.ServiceImpls;

@RestController
@RequestMapping("/employee")
public class Controller {

	@Autowired
	private ServiceImpls serviceImpl ;
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes="application/json")
	public void addNewEmployee(@RequestBody Employee emp) {
		System.out.println(emp);
		serviceImpl.addNewEmployee(emp);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/view/{start}/{count}", method=RequestMethod.GET, produces=org.springframework.http.MediaType.ALL_VALUE)
	public Resources viewAllEmployeeInPages(@PathVariable("start") int start,@PathVariable("count") int count)
	{
		List<Employee> tempEmployees=serviceImpl.viewAllEmployee();
		List<Employee> employees=new ArrayList<>();
		
		for(int i=start;i<start+count;i++)
		{
			employees.add(tempEmployees.get(i));
		}
		Link nextLink = linkTo(methodOn(this.getClass()).viewAllEmployeeInPages(start+count>=0?start-count:1,count)).withRel("nextLink");
		
		Link previousLink = linkTo(methodOn(this.getClass()).viewAllEmployeeInPages(start-count>=0?start-count:1,count)).withRel("nextLink");
		
		return new Resources<>(employees,nextLink,previousLink);
		
	}
	
	@RequestMapping(value="/view", method=RequestMethod.GET/*, produces=MediaType.ALL_VALUE*/)
	public Collection<Employee> viewAllEmployee() {
		
		//System.out.println(serviceImpl.viewAllEmployee());
		return serviceImpl.viewAllEmployee();
		
	}
	
	@RequestMapping(value="/delete/{empId}", method=RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable int empId) {

		 serviceImpl.deleteEmployee(empId);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT,  consumes="application/json")
	public void updateEmployee(@RequestBody Employee emp) throws EmployeeNotFound {
		
		System.out.println(emp);
		
			serviceImpl.updateEmployee(emp);
	
		
	}
	
	@RequestMapping(value="/{empName}", method=RequestMethod.GET)
	public Employee employeeDetails(@PathVariable Integer empId) {
		
		 return serviceImpl.searchEmployee(empId);
	}
	
}
