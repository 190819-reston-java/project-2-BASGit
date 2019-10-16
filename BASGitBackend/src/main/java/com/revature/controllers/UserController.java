package com.revature.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<List<User>> findAll(){
		
		List<User> u = userService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<User> save(User user){
		userService.save(user);
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@GetMapping(value = "/signout")
	@ResponseBody
	public ResponseEntity<User> signOut(User user, HttpServletRequest request, HttpServletResponse response){
		request.getSession().setAttribute("currentUser", null);
		
		try {
			response.sendRedirect("BASGit/static/BASGit/");
		} catch (IOException e) {
			e.printStackTrace();
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@PostMapping(value = "/profile/update")
	@ResponseBody
	public ResponseEntity<User> update(HttpServletRequest request, HttpServletResponse response){
		
		User user = userService.updateUser(request);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@PostMapping(value = "/signup")
	@ResponseBody
	public ResponseEntity<User> signUp(HttpServletRequest request, HttpServletResponse response){
		
		
		User u = userService.create(request);
		
		u = userService.save(u);
		
		
		try {
			response.sendRedirect("BASGit/static/BASGit/");
		} catch (IOException e) {
			e.printStackTrace();
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	
	@GetMapping(value = "/current")
	@ResponseBody
	public ResponseEntity<User> currentUser(HttpServletRequest request){
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		
		if (currentUser != null) {
			return ResponseEntity.status(HttpStatus.OK).body(currentUser);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		}
	
	
	@PostMapping(value = "/profile/update")
	@ResponseBody
	public ResponseEntity<User> updateProfile(HttpServletRequest request){
		
		User currentUser = userService.getCurrent(request);
		
		return ResponseEntity.status(HttpStatus.OK).body(currentUser);
		
	}
}
