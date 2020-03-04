package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController

public class HelloWorldController {
	
	//GET
	//URI - /hello-world
	//Method "hello world"
	
	/*
	@RequestMapping(method=RequestMethod.GET,path = "hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	*/
	
	//same functionality with the previous one
	@GetMapping(path = "hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	//hello-world-bean
	@GetMapping(path = "hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	//hello-world-bean with Path variable
	//hello-world-bean/path-variable/{name}
	@GetMapping(path = "hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	
}
