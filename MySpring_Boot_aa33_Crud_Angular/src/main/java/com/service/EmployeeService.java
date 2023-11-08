package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Employee;
import com.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository emprepo;
	
	
	public Employee addEmployee(Employee emp)
	{
	return	emprepo.save(emp);
	}

	public List<Employee> getAllEmployee()
	{
	return	emprepo.findAll();
		
	}
	
	public Employee getEmployeeById(int id)
	{
		Optional<Employee> emp = emprepo.findById(id);
		if(emp.isPresent())
		{
			return emp.get();
		}
		return null;
			
	}
	
	public void deleteEmployee(int id)
	{
		emprepo.deleteById(id);
	}
	
	public Employee updateEmployee(Employee emp)
	{
		Employee employee = emprepo.save(emp);
		
		
		return employee;
		
	
	}
	
}
