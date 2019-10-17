package com.revature.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Story;
import com.revature.models.User;
import com.revature.repositories.StoryRepository;

@Service
public class StoryService {

	@Autowired
	private StoryRepository storyRepository;

	public Story findOne(int id) {
		return storyRepository.findOne(id);
	}

	public List<Story> findAll() {
		return storyRepository.findAll();
	}

	public Story save(Story story) {
		storyRepository.save(story);

		return story;
	}

	public Story createNew(String JSONToProcess, HttpServletRequest request) {
		
		List<String> neededFields = getNeededFields(JSONToProcess);

		User u = (User) request.getSession().getAttribute("currentUser");
		Story s = new Story(0, neededFields.get(1), neededFields.get(0), "", u, false);


		File file = null;

		/*
		try {
			if (neededFields.get(2) != null) {
				Part submittedFilePart = request.getPart("picture");
				String submittedFileName = submittedFilePart.getName();
				InputStream fileContent = submittedFilePart.getInputStream();
				file = new File(submittedFileName);
				FileUtils.copyInputStreamToFile(fileContent, file);
			}
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
		catch (IllegalStateException e) {
			file = null;
		}
		*/

		if (u == null) {
			return null;
		}

		return storyRepository.createNew(s, file);

	}

	public Story highlight(Story s) {
		return storyRepository.highlight(s);
	}

	public void delete(Story s) {
		storyRepository.delete(s);

	}


	private List<String> getNeededFields(String JSONString){
		JSONString = JSONString.replaceAll("[{}]", "");
		String[] formJSONSplit = JSONString.split(",");
		List<String> neededFields = new ArrayList<String>();
		for (String JSONField : formJSONSplit) {
			neededFields.add(JSONField.split(":")[1].replaceAll("\"", ""));
		}
		
		return neededFields;
	}
	
	public Story handleStory(String adminHandlerJSON, HttpServletRequest request) {

		String[] handleDecisions = adminHandlerJSON.split(" ");

		int storyID = Integer.valueOf(handleDecisions[0]);
		String decision = handleDecisions[1];

		Story s = findOne(storyID);

		if (decision == "h") {
			s = highlight(s);
			s = storyRepository.save(s);
		} else if (decision == "r") {
			delete(s);
			s = null;
		}

		return s;

	}

	public List<Story> findAllByAuthor(int id) {
		return storyRepository.findAllByAuthor(id);
	}

	public List<Story> findAllFeatured() {
		return storyRepository.findAllFeatured();
	}

}
