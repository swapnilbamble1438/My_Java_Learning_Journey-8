package com.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;
import com.service.EmployeeService;


@RestController
@CrossOrigin(origins = "*")
public class EmpController {
	
	@Autowired
	private EmployeeService empserv;
	
	
//	{
//		   "name":"Swapnil",
//		   "address":"Mumbra",
//		   "email":"swapnil@gmail.com",
//		   "phone":"1234",
//		   "salary":"20000"
//		}
	
	@GetMapping("/allemp")
	public List<Employee> getAllEmployees()
	{
		
		return this.empserv.getAllEmployee();
	}
	
	
	
	
	@GetMapping("/emp/{id}")
	public Employee getEmployee(@PathVariable int id)
	{
		Employee emp = empserv.getEmployeeById(id);
			
		return emp;
	}
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee emp)
	{
		Employee employee = empserv.addEmployee(emp);
				
		return employee;
	}
	
	@PostMapping("/update")
	public Employee updateEmployee(@RequestBody Employee emp)
	{
		Employee employee = empserv.updateEmployee(emp);
		
		return employee;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteemp(@PathVariable int id)
	{
		 empserv.deleteEmployee(id);
		
		
		return "Employee Deleted Successfully...";
	}
}
