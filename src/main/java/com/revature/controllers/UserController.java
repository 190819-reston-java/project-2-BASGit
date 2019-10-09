package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.User;
import com.revature.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/home")
	public String home() {
		return "home";
	}

	@GetMapping("/users")
	@ResponseBody
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	@ResponseBody
	public ResponseEntity<User> findOne(@PathVariable("id") String id) {
		
		User u = userService.findOne(id);
		if(u != null) {
			return ResponseEntity.status(HttpStatus.OK).body(u);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@PutMapping("/users")
	@ResponseBody
	public ResponseEntity<User> upsert(@RequestBody User u){
		User response = userService.upsert(u);
		
		return ResponseEntity.ok(response);
	}
}
