package com.revature.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public ResponseEntity<String> sayHello(){
		return new ResponseEntity<String>("Hello!", HttpStatus.OK);
	}
	
	@PostMapping(value="/test/formSubmission")
	public ResponseEntity<String> buildForm(@RequestBody String JSON){
		return ResponseEntity.status(HttpStatus.OK).body(JSON);
	}
	
}
