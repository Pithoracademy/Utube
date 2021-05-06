package com.pithoracademy.Utube.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping
	public String sayHello() {
		return "Hello";
	}
	
	@GetMapping("user/{userName}")
	public String sayHi(@PathVariable String userName) {
		return "Hi " + userName + "!";
	}
	
	@GetMapping("user")
	public String sayHelloUser(@RequestParam String user) {
		return "Hello " + user + "!"; 
	}
}
