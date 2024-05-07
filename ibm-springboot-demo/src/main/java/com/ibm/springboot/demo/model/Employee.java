//http://localhost:9090/swagger-ui/index.html
package com.ibm.springboot.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("employess")
public class Employee {

	@Id
	private String  emp_id;
	private String name; // name
	private String email;
	private Long aadhaar;
	private Double salary;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getAadhaar() {
		return aadhaar;
	}
	public void setAadhaar(Long aadhaar) {
		this.aadhaar = aadhaar;
	}
	
	
	public Employee( String name, String email, long aadhaar, Double salary) {
		super();
		this.name = name;
		this.email = email;
		this.aadhaar = aadhaar;
		this.salary = salary;
	}
	public Employee(String id , String name , Double salary){
		this.emp_id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public Employee() {
		super();
		
	}
	public String getEmpid() {
		return emp_id;
	}
	public void setEmpid(String empid) {
		this.emp_id = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", email=" + email + ", aadhaar=" + aadhaar
				+ ", salary=" + salary + "]";
	}
	
	
	
}
