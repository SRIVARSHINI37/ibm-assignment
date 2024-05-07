package com.ibm.springboot.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ibm.springboot.demo.model.Employee;

@Service
public class EmailService {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(Employee employee) {
		LOG.info(employee.getEmail());
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("srivarshini456@yahoo.com");
		mailMessage.setTo(employee.getEmail());
		mailMessage.setSubject(employee.getName().toUpperCase() + "'s Data Accessed");
		mailMessage.setText("Hi " + employee.getName() + ". \nYour data in the database with the id "
				+ employee.getEmpid() + " was accessed just now.");
		LOG.info(mailMessage.toString());
		javaMailSender.send(mailMessage);
	}

}
