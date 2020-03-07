package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	//versioning: basic control of URI
	//URI versioning (Twitter)
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("v2 /person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	//Versioning RESTful service - header and content negotiation approach
	//1. using request pattern, request parameter versioning (Amazon)
	//http://localhost:8080/person/param?version=1
	@GetMapping(value = "person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Bob Charlie");
	}
	
	//http://localhost:8080/person/param?version=2
	@GetMapping(value = "person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	//Another option of doing version: header versioning (microsoft)
	//2. using header pattern 
	@GetMapping(value = "person/header", headers = "X_API_VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Bob Charlie");
	}
	
	//http://localhost:8080/person/param?version=2
	@GetMapping(value = "person/header", headers = "X_API_VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	
	//Another option of doing version: produces
	//using header params, accept header versioning/mine type persioning (Github)
		@GetMapping(value = "person/produces", produces = "application/vnd.company.app-v1+json")
		public PersonV1 producesV1() {
			return new PersonV1("Bob Charlie");
		}
		
		//http://localhost:8080/person/param?version=2
		@GetMapping(value = "person/produces", produces = "application/vnd.company.app-v2+json")
		public PersonV2 producesV2() {
			return new PersonV2(new Name("Bob","Charlie"));
		}
}
