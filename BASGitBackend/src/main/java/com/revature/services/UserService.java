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

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User save(User user) {
		userRepository.save(user);

		return user;
	}

	public User findByUsername(String username) {
		return userRepository.findByUserName(username);
	}

	public User create(User user, HttpServletRequest request) {

		User u = userRepository.save(user);

		request.getSession().setAttribute("currentUser", u);

		return u;
	}

	public User getCurrent(HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		return currentUser;
	}

	public User updateUser(String JSON, HttpServletRequest request) {
		User currentUser = getCurrent(request);

		List<String> neededFields = getNeededFields(JSON);
		
		if (!neededFields.get(2).equals("")) {
			currentUser.setPassword(neededFields.get(2));
		}
		if (!neededFields.get(0).equals("")) {
			currentUser.setFullname(neededFields.get(0));
		}
		if (!neededFields.get(1).equals("")) {
			currentUser.setUsername(neededFields.get(1));
		}
		/*
		File file = null;
		try {
			Part submittedFilePart = request.getPart("picture");
			String submittedFileName = submittedFilePart.getName();
			InputStream fileContent = submittedFilePart.getInputStream();
			file = new File(submittedFileName);
			FileUtils.copyInputStreamToFile(fileContent, file);
		} catch (IOException | ServletException e) {
			e.printStackTrace();
			return null;
		}

		String imageURL = userRepository.uploadImage(file, currentUser);
		updateUser.setAvatarURL(imageURL);
		*/
		
		currentUser = userRepository.save(currentUser);

		return currentUser;
	}

	public User login(String JSONString) {
		
		List<String> neededFields = getNeededFields(JSONString);

		return userRepository.findByUserNameAndPassword(neededFields.get(0), neededFields.get(1));
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
	
	public User signUp(String JSONString) {

		List<String> neededFields = getNeededFields(JSONString);
		
		User u = new User(0, neededFields.get(0), neededFields.get(1),
				"https://allen-gworek-llc-image-storage.s3.amazonaws.com/defaultprofilepic.png",
				neededFields.get(3).equals("1908-REVATURE"), neededFields.get(2), null);

		return u;
	}

}
