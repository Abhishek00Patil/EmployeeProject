package com.jbk.CrudOperation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController 
{

 // This comment is for git is working or not

	@Autowired
	EmployeeRepo employeeRepo;
	
	@PostMapping(value = "/createEmp")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return employeeRepo.save(employee);
		
	}
	
	
	@GetMapping(value = "/getEmp/{id}")
	public Optional<Employee> getEmployee(@PathVariable Integer id)
	{
		return employeeRepo.findById(id);
		
	}
	
	@PutMapping(value = "/updateEmp")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		Optional<Employee> oldEmp = employeeRepo.findById(employee.getEmployeeId());
		
		if(oldEmp.isPresent())
		{
		  return employeeRepo.save(employee);
		}
		
		return null;
	}
	
	@DeleteMapping(value = "/deleteEmp/{id}")
	public String deleteEmployee(@PathVariable Integer id)
	{
		employeeRepo.deleteById(id);
		return "Employee Deleted..";
		
	}
}
