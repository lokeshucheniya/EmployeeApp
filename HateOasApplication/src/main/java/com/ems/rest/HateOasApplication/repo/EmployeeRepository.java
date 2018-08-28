package com.ems.rest.HateOasApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.rest.HateOasApplication.pojo.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
