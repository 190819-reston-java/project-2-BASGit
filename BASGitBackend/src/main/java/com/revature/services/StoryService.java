package com.revature.services;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Story;
import com.revature.models.User;
import com.revature.repositories.StoryRepository;

@Service
public class StoryService  {

	@Autowired
	private StoryRepository storyRepository;
	
	
	public Story findOne(int id) {
		return storyRepository.findOne(id);
	}
	
	
	public Set<Story> findAll(){
		return storyRepository.findAll();
	}
	
	
	public Story save(Story story) {
		storyRepository.save(story);
		
		return story;
	}


	public Story createNew(Story story, User u) {
		storyRepository.createNew(story, u);
		
		return story;
		
	}
}
