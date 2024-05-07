package com.ibm.springboot.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ibm.springboot.demo.model.Employee;
import com.ibm.springboot.demo.service.EmployeeService;

@SpringBootTest
class AppTests {

	@Autowired
	private EmployeeService employeeService;
	
	private static final Logger LOG = LoggerFactory.getLogger(AppTests.class);
	
	@BeforeAll
	
	public static void setUp() {
		LOG.info("Before all");
	}
	@AfterAll
	
	public static void tearDown() {
		LOG.info("After all");
	}
	
//	@Test
//	public void testAllEmps() {
//		assertEquals(employeeService.getAllEmployees(), 11);
//	}
	
//	@Test
//	public void testAddEmp() {
//		Employee emp = new Employee("test data","testing@gmail.com",8907000000L,9000.90);
//		assertEquals(employeeService.addEmployee(emp),emp);
//	}
	
	@ParameterizedTest
	@ValueSource(strings = { "Balaji", "Supriya" })
	void testGetEmpsByName(String name) {
		assertEquals(name, employeeService.getEmployeeByName(name).get(0).getName());
	}

	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	@Test
	public void testAllEmpsTimeout() {
		assertTimeout(Duration.ofMillis(1000), () -> {
			employeeService.getAllEmployees();
		});

	}

	
	

}
