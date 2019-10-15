package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<User> findOne(@PathVariable("id") int id) {

		User u =  userService.findOne(id);

		if (u != null) {
			return ResponseEntity.status(HttpStatus.OK).body(u);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@GetMapping(value = "/name/{username}")
	@ResponseBody
	public ResponseEntity<User> findByUsername(@PathVariable("username") String username) {
		
		User u = userService.findByUsername(username);
		
		if(u != null) {
			return ResponseEntity.status(HttpStatus.OK).body(u);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<Set<User>> findAll(){
		
		Set<User> u = userService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<User> save(User user){
		userService.save(user);
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

}
