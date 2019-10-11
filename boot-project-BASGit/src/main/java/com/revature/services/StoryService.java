package com.revature.services;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.IStory;
import com.revature.models.Story;
import com.revature.repositories.IStoryRepository;

@Service
public class StoryService implements IStoryservice {

	private IStoryRepository storyRepository;
	
	@Override
	public IStory findOne(int id) {
		return storyRepository.findOne(id);
	}
	
	@Override
	public Set<IStory> findAll(){
		return storyRepository.findAll();
	}
	
	@Override
	public IStory save(IStory story) {
		storyRepository.save(story);
		
		return story;
	}
}
