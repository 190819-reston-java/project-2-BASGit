package com.revature.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

	public Story createNew(HttpServletRequest request) {

		User u = (User) request.getSession().getAttribute("currentUser");
		Story story = new Story(0, request.getParameter("synopsis"), request.getParameter("title"), "", u, false);

		File file = null;

		try {
			if (request.getPart("picture") != null) {
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

		if (u == null) {
			return null;
		}

		return storyRepository.createNew(story, file);

	}

	public Story highlight(Story s) {
		return storyRepository.highlight(s);
	}

	public void delete(Story s) {
		storyRepository.delete(s);

	}

	public Story handleStory(HttpServletRequest request) {

		String[] handleDecisions = request.getParameter("changestory").split(" ");

		int storyID = Integer.valueOf(handleDecisions[0]);
		String decision = handleDecisions[1];

		Story s = findOne(storyID);

		if (decision == "h") {
			s = highlight(s);
		} else if (decision == "r") {
			delete(s);
			s = null;
		}

		return s;

	}

}
