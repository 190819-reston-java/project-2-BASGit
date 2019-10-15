package com.revature.controllers;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Story;
import com.revature.models.Story;
import com.revature.services.StoryService;

@RestController
@RequestMapping(value = "/stories")
public class StoryController {

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

}