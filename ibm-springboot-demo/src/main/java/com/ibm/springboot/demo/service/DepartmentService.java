package com.ibm.springboot.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.springboot.demo.model.Department;


@Service
public interface DepartmentService {
	
	public abstract List<Department> getAllDepartments();
//
	public abstract Department getDepartmentById(String departmentId);
//
	public abstract Department addDepartment(Department department);
	
	public abstract Department deleteDepartmentById(String departmentId);
	
	public abstract Department updateDepartment(Department department);
	
	public abstract List<Department> getDepartmentByName(String departmentName);

}
