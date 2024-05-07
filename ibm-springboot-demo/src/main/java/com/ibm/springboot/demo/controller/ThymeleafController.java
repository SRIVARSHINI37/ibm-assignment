package com.ibm.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ibm.springboot.demo.model.Employee;
import com.ibm.springboot.demo.service.EmployeeService;

@Controller
public class ThymeleafController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/user")
	public String user(Model model) {
		List<Employee> empList = employeeService.getAllEmployees();
		model.addAttribute("firstName", empList.get(0).getName());
		return "user";
	}

}
