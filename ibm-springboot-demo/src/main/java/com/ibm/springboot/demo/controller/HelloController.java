package com.ibm.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("hello")
public class HelloController {
			
		@GetMapping("/hi")
		public String hi() {
			System.out.println("From Hello");
			return "From Hello";
		}
		
		@GetMapping("/greet")
		public String greeting() {
			
			System.out.println("WElcome");
			return "Welcome!";
		}
		

}
