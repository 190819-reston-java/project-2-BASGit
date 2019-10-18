package com.revature.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
//import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Story;
import com.revature.models.User;
import com.revature.services.StoryService;

@RestController
@RequestMapping(value = "/stories")
public class StoryController {
	
	static void testingString() {
		System.out.println("testedMe");
	}

	@Override
	public String toString() {
		return "StoryController [storyService=" + this.storyService + ", findAll()=" + findAll() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Autowired
	private StoryService storyService;

	@GetMapping(value = "/{id}")

	@ResponseBody
	public ResponseEntity<Story> findOne(@PathVariable("id") int id) {

		Story u = this.storyService.findOne(id);

		if (u != null) {
			return ResponseEntity.status(HttpStatus.OK).body(u);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<ArrayList<Story>> findAll() {

		ArrayList<Story> u = this.storyService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}

	@PutMapping
	@ResponseBody
	public ResponseEntity<Story> save(Story story) {
		this.storyService.save(story);

		return ResponseEntity.status(HttpStatus.OK).body(story);
	}
	
	
//	@Temporal(TemporalType.DATE)
//	@Column(name="date_time")
//	private Timestamp dateTime;
	
	@PutMapping(value = "/create/new")
	@ResponseBody
	public ResponseEntity<Story> createNew(HttpServletRequest request, HttpServletResponse response, Story story) {

		User u = (User) request.getSession().getAttribute("currentUser");
		
		User t = (User) request.getSession().getAttribute("To_User"); // TODO: add this to HTML?
		
		Timestamp ts = new Timestamp(System.currentTimeMillis());

		if(u == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		this.storyService.createNew(story, u, t, ts);
		return ResponseEntity.status(HttpStatus.OK).body(story);
	}

}