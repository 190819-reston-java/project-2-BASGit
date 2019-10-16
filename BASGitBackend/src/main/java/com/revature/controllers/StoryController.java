package com.revature.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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

	@PostMapping(value = "/profiles/submit")
	@ResponseBody
	public ResponseEntity<Story> createNew(HttpServletRequest request, HttpServletResponse response) {

		User u = (User) request.getSession().getAttribute("currentUser");
		Story story = new Story(0, request.getParameter("synopsis"), request.getParameter("title"), "", u);
		
		File file = null;
		
		try {
		Part submittedFilePart = request.getPart("picture");
		String submittedFileName = submittedFilePart.getName();
		InputStream fileContent = submittedFilePart.getInputStream();
		file = new File(submittedFileName);
			FileUtils.copyInputStreamToFile(fileContent, file);
		}
		catch (IOException | ServletException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(story);
		}
		
		if(u == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		storyService.createNew(story, file);
		return ResponseEntity.status(HttpStatus.OK).body(story);
	}

}