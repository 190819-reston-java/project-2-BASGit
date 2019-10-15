package com.revature.controllers;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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

	@Autowired
	private StoryService storyService;

	@GetMapping(value = "/{id}")

	@ResponseBody
	public ResponseEntity<Story> findOne(@PathVariable("id") int id) {

		Story u = storyService.findOne(id);

		if (u != null) {
			return ResponseEntity.status(HttpStatus.OK).body(u);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<Set<Story>> findAll() {

		Set<Story> u = storyService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}

	@PutMapping
	@ResponseBody
	public ResponseEntity<Story> save(Story story) {
		storyService.save(story);

		return ResponseEntity.status(HttpStatus.OK).body(story);
	}
	
	@PutMapping(value = "/create/new")
	@ResponseBody
	public ResponseEntity<Story> createNew(HttpServletRequest request, HttpServletResponse response, Story story) {

		User u = (User) request.getSession().getAttribute("currentUser");
		
		if(u == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		storyService.createNew(story, u);
		return ResponseEntity.status(HttpStatus.OK).body(story);
	}

}