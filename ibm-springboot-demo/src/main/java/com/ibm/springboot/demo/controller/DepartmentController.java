package com.ibm.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.demo.model.Department;
import com.ibm.springboot.demo.model.Employee;
import com.ibm.springboot.demo.service.DepartmentService;


@RestController
@RequestMapping("dept")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("get-dept-by-id/{did}")
	public ResponseEntity<Department> getDeptById(@PathVariable(name = "did") String departmentId) {
		System.out.println(departmentId);
		Department department = departmentService.getDepartmentById(departmentId);
		System.out.println(department.toString());
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Department data fetched successfully!");
		ResponseEntity<Department> response = new ResponseEntity<Department>(department, headers, status);
		return response;
	}
	
	@GetMapping("get-dept-by-name/{deptName}")
	public ResponseEntity<List<Department>> getEmpName(@PathVariable(name = "deptName") String deptName) {
		List<Department> deptList = departmentService.getDepartmentByName(deptName);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Department data fetched successfully!");
		ResponseEntity<List<Department>> response = new ResponseEntity<List<Department>>(deptList, headers, status);
		return response;
	}
	
	@GetMapping("get-all-dept")
	public ResponseEntity<List<Department>> getAllDept() {
		List<Department> deptList = departmentService.getAllDepartments();
		deptList.forEach(System.out::println);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All Department data fetched successfully!");
		ResponseEntity<List<Department>> response = new ResponseEntity<List<Department>>(deptList, headers, status);
		return response;
	}
	
	@PostMapping("add-dept")
	public ResponseEntity<Department> addDept(@RequestBody Department department) {
		Department deptToBeAdded = departmentService.addDepartment(department);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Department added successfully!");
		ResponseEntity<Department> response = new ResponseEntity<Department>(deptToBeAdded, headers, status);
		return response;
	}
	
	@DeleteMapping("delete-dept/{did}")
	public ResponseEntity<Department> deleteDept(@PathVariable(name = "did") String departmentId) {
		System.out.println(departmentId);
		Department deptToBeDeleted = departmentService.deleteDepartmentById(departmentId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Department deleted successfully!");
		ResponseEntity<Department> response = new ResponseEntity<Department>(deptToBeDeleted, headers, status);
		return response;
	}
	
	@PutMapping("update-dept")
	public ResponseEntity<Department> updateDept(@RequestBody Department department) {
		Department deptToBeAdded = departmentService.updateDepartment(department);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Department updated successfully!");
		ResponseEntity<Department> response = new ResponseEntity<Department>(deptToBeAdded, headers, status);
		return response;
	}
	
	

}
