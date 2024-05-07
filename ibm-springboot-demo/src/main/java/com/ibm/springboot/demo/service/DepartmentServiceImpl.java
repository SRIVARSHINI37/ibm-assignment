package com.ibm.springboot.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.demo.exception.DepartmentNotFoundException;
import com.ibm.springboot.demo.exception.EmployeeNotFoundException;
import com.ibm.springboot.demo.model.Department;
import com.ibm.springboot.demo.model.Employee;
import com.ibm.springboot.demo.repository.DepartmentRepository;



@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	DepartmentRepository departmentRepository;
//	

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Department> getAllDepartments() {
		LOG.info("getAllDepartments");
		//return departmentRepository.findAll();
		Iterable<Department> deptIterable = departmentRepository.findAll();
		List<Department> deptList = new ArrayList<>();
	    
	    deptIterable.forEach(deptList::add);
	    
	    if (deptList.isEmpty()) {
	        String errorMessage = "Department list is empty";
	        LOG.warn(errorMessage);
	        throw new DepartmentNotFoundException(errorMessage);
	    }
	    
	    return deptList;
	}

	@Override
	public Department getDepartmentById(String departmentId) {
		LOG.info(departmentId.toString());
		//return departmentRepository.findById(departmentId).get();
		Optional<Department> deptOptional = departmentRepository.findById(departmentId);
		if (deptOptional.isEmpty()) {
			String errorMessage = "Department with id " + departmentId + " is not found!";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundException(errorMessage);
		}
		return deptOptional.get();

	}

	@Override
	public Department addDepartment(Department department) {
		LOG.info(department.toString());
		return departmentRepository.save(department);
	}
	
	@Override
	public Department deleteDepartmentById(String departmentId) {
		LOG.info(departmentId);
		Department deptToBeDeleted = this.getDepartmentById(departmentId);
		departmentRepository.deleteById(departmentId);
		return deptToBeDeleted;
	}

	@Override
	public Department updateDepartment(Department department) {
		LOG.info(department.toString());
		Optional<Department> optionalExistingDepartment = departmentRepository.findById(department.getDepartmentId());
		// better code is needed? 
		LOG.info(optionalExistingDepartment.toString());
		if(optionalExistingDepartment.isPresent()) {
			 Department existingDepartment = optionalExistingDepartment.get();
			 existingDepartment.setManagerId(department.getManagerId());
			 existingDepartment.setLocation(department.getLocation());
		        return departmentRepository.save(existingDepartment);
		}
		else {
			String errorMessage = "Department is not found , add new department";
	        LOG.warn(errorMessage);
	        throw new DepartmentNotFoundException(errorMessage);
		}

	}

	@Override
	public List<Department> getDepartmentByName(String departmentName) {
		LOG.info(departmentName);
		List<Department> deptList = departmentRepository.findByDepartmentName(departmentName);
		if (deptList.isEmpty()) {
			String errorMessage = "Department with Name " + departmentName + " is not found!";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundException(errorMessage);
		}
		return deptList;

	}
	

	
}
