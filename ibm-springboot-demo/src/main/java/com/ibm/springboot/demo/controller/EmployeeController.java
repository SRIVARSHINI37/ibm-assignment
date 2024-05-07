package com.ibm.springboot.demo.controller;

import org.springframework.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.demo.model.Employee;
import com.ibm.springboot.demo.service.EmployeeService;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("emp")
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@GetMapping("/hi")
	public String hi() {
		System.out.println("From Employee");
		return "From Employee";
	}
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(path = "get-emp-pages", produces = "application/json")
	public ResponseEntity<Page<Employee>> getEmpPages(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer size, @RequestParam(defaultValue = "id") String sortBy) {
		Page<Employee> empList = employeeService.getEmployeePages(page, size, sortBy);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All employees data fetched successfully!");
		ResponseEntity<Page<Employee>> response = new ResponseEntity<Page<Employee>>(empList, headers, status);
		return response;
	}

	@GetMapping("get-emp-by-id/{eid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") String employeeId) {
		System.out.println(employeeId);
		Employee employee = employeeService.getEmployeeById(employeeId);
		System.out.println(employee.toString());
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee data fetched successfully!");
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(employee, headers, status);
		return response;
	}

	@GetMapping("get-all-emps")
	public ResponseEntity<List<Employee>> getAllEmps() {
		List<Employee> empList = employeeService.getAllEmployees();
		empList.forEach(System.out::println);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All employees data fetched successfully!");
		ResponseEntity<List<Employee>> response = new ResponseEntity<List<Employee>>(empList, headers, status);
		return response;
	}
	
	@GetMapping("get-emp-by-name/{empName}")
	public ResponseEntity<List<Employee>> getEmpName(@PathVariable(name = "empName") String empName) {
		System.out.println(empName);
		List<Employee> empList = employeeService.getEmployeeByName(empName);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employees data fetched successfully!");
		ResponseEntity<List<Employee>> response = new ResponseEntity<List<Employee>>(empList, headers, status);
		return response;
	}
	
	@PostMapping("add-emp")
	public ResponseEntity<Employee> addEmp(@RequestBody Employee employee) {
		Employee empToBeAdded = employeeService.addEmployee(employee);
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee added successfully!");
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(empToBeAdded, headers, status);
		return response;
	}
	@DeleteMapping("delete-emp/{eid}")
	public ResponseEntity<Employee> deleteEmp(@PathVariable(name = "eid") String employeeId) {
		Employee empToBeDeleted = employeeService.deleteEmployee(employeeId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee deleted successfully!");
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(empToBeDeleted, headers, status);
		return response;
	}
//	
	@PutMapping("update-emp")
		public ResponseEntity<Employee> updateEmp(@RequestBody Employee employee) {
			Employee empToBeAdded = employeeService.updateEmployee(employee);
			HttpStatus status = HttpStatus.CREATED;
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "Employee updated successfully!");
			ResponseEntity<Employee> response = new ResponseEntity<Employee>(empToBeAdded, headers, status);
			return response;
		}
	

}
