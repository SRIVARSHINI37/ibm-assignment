package com.ibm.springboot.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ibm.springboot.demo.exception.EmployeeNotFoundException;
import com.ibm.springboot.demo.model.Employee;
import com.ibm.springboot.demo.repository.EmployeeRepository;
@CrossOrigin(origins = "*")
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmployeeRepository employeeRepository;
//	
//	private List<Employee> empList = new ArrayList<>();
	
	@Override
	public Page<Employee> getEmployeePages(Integer page, Integer size, String sortBy) {
		PageRequest pageable = PageRequest.of(page, size, Sort.by(sortBy));
		return employeeRepository.findAll(pageable);
	}
//	
	@Override
	public Employee getEmployeeById(String employeeId) {
		LOG.info(employeeId.toString());
		Optional<Employee> empOptional = employeeRepository.findById(employeeId);
		if (empOptional.isEmpty()) {
			String errorMessage = "Employee with id " + employeeId + " is not found!";
			LOG.warn(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
		}
		return empOptional.get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		//return empList;
		LOG.info("getAllEmployees");
//		return employeeRepository.findAll();
		Iterable<Employee> empIterable = employeeRepository.findAll();
		List<Employee> empList = new ArrayList<>();
	    
	    empIterable.forEach(empList::add);
	    
	    if (empList.isEmpty()) {
	        String errorMessage = "Employee list is empty";
	        LOG.warn(errorMessage);
	        throw new EmployeeNotFoundException(errorMessage);
	    }
	    
	    return empList;
	}
	

	@Override
	public Employee updateEmployee(Employee employee) {
		LOG.info(employee.toString());
		Optional<Employee> optionalExistingEmployee = employeeRepository.findById(employee.getEmpid());
		// better code is needed? 
		LOG.info(optionalExistingEmployee.toString());
		if(optionalExistingEmployee.isPresent()) {
			 Employee existingEmployee = optionalExistingEmployee.get();
			 existingEmployee.setSalary(employee.getSalary());
			 existingEmployee.setName(employee.getName());
		        return employeeRepository.save(existingEmployee);
		}
		else {
			String errorMessage = "Employee is not found , add new employee";
	        LOG.warn(errorMessage);
	        throw new EmployeeNotFoundException(errorMessage);
		}
		
	}
	
	@Override
	public Employee deleteEmployee(String employeeId) {
		LOG.info(employeeId.toString());
		employeeRepository.deleteById(employeeId);
		return null;
	}

	@Override
	public List<Employee> getEmployeeByName(String empName) {
		LOG.info(empName);
//		return employeeRepository.findByName(empName);
		List<Employee> empList = employeeRepository.findByName(empName);
		if (empList.isEmpty()) {
			String errorMessage = "Employee with firstName " + empName + " is not found!";
			LOG.warn(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
		}
		return empList;
	}
	
	@Override
	public Employee addEmployee(Employee employee) {
		LOG.info(employee.toString());
		return employeeRepository.save(employee);
	}


}
