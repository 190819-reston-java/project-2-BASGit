package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class StoryDao {
	
	private HibernateTemplate template;

	private void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public void saveStory(Story s) {
		template.save(s);
	}

	public void updateStory(Story s) {
		template.update(s);
	}

	public void deleteStory(Story s) {
		template.delete(s);
	}

	public Story getStoryByID(int ID) {
		Story s= (Story) template.get(Story.class, ID);
		return s;
	}

	public List<Story> returnAllStories() {
		List<Story> list = new ArrayList<Story>();
		list = template.loadAll(Story.class);
		return list;
	}
}
