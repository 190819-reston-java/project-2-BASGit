package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

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
	public ResponseEntity<List<String>> buildForm(@RequestBody String JSON){
		return ResponseEntity.status(HttpStatus.OK).body(getNeededFields(JSON));
	}

	private List<String> getNeededFields(String JSONString){
		JSONString = JSONString.replaceAll("[{}]", "");
		String[] formJSONSplit = JSONString.split(",");
		List<String> neededFields = new ArrayList<String>();
		for (String JSONField : formJSONSplit) {
			try {
			neededFields.add(JSONField.split(":")[1].replaceAll("\"", ""));
			}
			catch(ArrayIndexOutOfBoundsException e) {
				neededFields.add("***PROBLEMATIC FIELD: " + JSONField);
			}
		}
		
		return neededFields;
	}
	
	@PostMapping(value="/test/storySubmission")
	public ResponseEntity<List<String>> buildStory(@RequestBody String JSON){
		return ResponseEntity.status(HttpStatus.OK).body(getNeededStoryFields(JSON));
	}
	
	private List<String> getNeededStoryFields(String JSONString){
		
		JSONString = JSONString.substring(1, JSONString.length() - 1);
		
		JSONString = JSONString.replaceFirst("\"title\":", "");
		String[]JSONParts = JSONString.split("\"synopsis\":");
		List<String> neededFields = new ArrayList<String>();
		for(String part : JSONParts) {
			neededFields.add(part);
		}
		
		return neededFields;
	}
	
}
