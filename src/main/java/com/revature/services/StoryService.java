package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.model.Story;
import com.revature.model.StoryDao;

@Service
public class StoryService {

	private List<Story> stories = new ArrayList<Story>();
	private StoryDao sdao;

	public StoryService() {
		stories = sdao.returnAllStories();
	}

	public Story findOne(int storyID) {
		for (Story s : stories) {
			if (s.getStoryID() == storyID) {
				return s;
			}
		}
		return null;
	}
	
	public List<Story> findAllByAuthorID(String authorID){
		List<Story> list = new ArrayList<Story>();
		
		for(Story s : stories) {
			if(s.getAuthorID() == authorID) {
				list.add(s);
			}
		}
		
		return list;
	}
	
	public boolean exists(int storyID) {
		if (findOne(storyID) != null) {
			return true;
		}
		return false;
	}
	
	public Story upsert(Story s) {
		if(exists(s.getStoryID())) {
			sdao.updateStory(s);;
		}
		else {
			sdao.saveStory(s);
		}
		
		return s;
	}

}
