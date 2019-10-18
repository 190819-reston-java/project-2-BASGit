package com.revature.services;

import java.sql.Timestamp;
import java.util.ArrayList;
//import java.util.Set;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Story;
import com.revature.models.User;
import com.revature.repositories.StoryRepository;

@Service
public class StoryService  {

	@Autowired
	private StoryRepository storyRepository;
	
	
	public Story findOne(int id) {
		return this.storyRepository.findOne(id);
	}
	
	
	public ArrayList<Story> findAll(){
		return this.storyRepository.findAll();
	}
	
	
	public Story save(Story story) {
		this.storyRepository.save(story);
		
		return story;
	}
//	@Temporal(TemporalType.DATE)
//	@Column(name="date_time")
//	private Timestamp dateTime;

	public Story createNew(Story story, User u, User t, Timestamp ts) {
		this.storyRepository.createNew(story, u, t, ts);
		
		return story;
		
	}
}
