package com.revature.repositories;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Story;
import com.revature.models.User;

@Repository
public class StoryRepository {

	@Autowired
	private SessionFactory sf;

	
	@Transactional
	public Story findOne(int id) {
		Session s = sf.getCurrentSession();
		return (Story) s.get(Story.class, id);
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Story> findAll() {
		Session s = sf.getCurrentSession();

		return new HashSet<Story>(s.createCriteria(Story.class).list());

	}

	
	@Transactional
	public Story save(Story story) {
		Session s = sf.getCurrentSession();

		s.saveOrUpdate(story);

		return story;
	}


	public Story createNew(Story story, User u) {
		Session s = sf.getCurrentSession();
		
		story.setAuthor(u);
		
		s.saveOrUpdate(story);
		
		return story;
		
	}
}
