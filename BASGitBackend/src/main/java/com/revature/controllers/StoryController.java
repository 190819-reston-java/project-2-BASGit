package com.revature.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
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

		Story s = storyService.findOne(id);

		if (s != null) {
			return ResponseEntity.status(HttpStatus.OK).body(s);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	@GetMapping(value = "/user/{id}")
	@ResponseBody
	public ResponseEntity<List<Story>> findAllByUser(@PathVariable("id") int id){
		List<Story> s = storyService.findAllByAuthor(id);
		
		if(s != null) {
			return ResponseEntity.status(HttpStatus.OK).body(s);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@GetMapping(value = "/featured")
	@ResponseBody
	public ResponseEntity<List<Story>> findAllFeatured(){
		List<Story> s = storyService.findAllFeatured();
		
		if(s != null) {
			return ResponseEntity.status(HttpStatus.OK).body(s);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Story>> findAll() {

		List<Story> s = storyService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(s);
	}
	
	@PostMapping("/admin/handle")
	@ResponseBody
	public ResponseEntity<Story> handleStory(@RequestBody String adminHandlerJSON, HttpServletRequest request, HttpServletResponse response){
		
		Story s = storyService.handleStory(adminHandlerJSON, request);
		return ResponseEntity.status(HttpStatus.OK).body(s);
		
	}

	@PutMapping
	@ResponseBody
	public ResponseEntity<Story> save(Story story) {
		storyService.save(story);

		return ResponseEntity.status(HttpStatus.OK).body(story);
	}

	@PostMapping(value = "/profiles/submit")
	@ResponseBody
	public ResponseEntity<Story> createNew(@RequestBody String JSONStoryCreation, HttpServletRequest request, HttpServletResponse response) {

		Story story = storyService.createNew(JSONStoryCreation, request);
		
		if(story != null) {
			return ResponseEntity.status(HttpStatus.OK).body(story);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}