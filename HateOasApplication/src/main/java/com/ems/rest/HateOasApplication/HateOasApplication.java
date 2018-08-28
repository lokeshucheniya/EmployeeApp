package com.ems.rest.HateOasApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ems.rest.HateOasApplication.pojo.Employee;
import com.ems.rest.HateOasApplication.service.ServiceImpls;
@SpringBootApplication
public class HateOasApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(HateOasApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ServiceImpls  repository)
	{
		return (args) ->{
			repository.addNewEmployee(new Employee(101,"Sample1",10000));
			repository.addNewEmployee(new Employee(102,"Sample2",20000));
			
			System.out.println("Database initially loaded");
		};
	}
}
