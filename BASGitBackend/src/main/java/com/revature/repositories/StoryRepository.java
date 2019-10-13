package com.revature.repositories;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Story;

@Repository
public class StoryRepository {

	@Autowired
	private SessionFactory sf;

	
	@Transactional(propagation = Propagation.MANDATORY)
	public Story findOne(int id) {
		Session s = sf.getCurrentSession();
		return (Story) s.get(Story.class, id);
	}

	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.MANDATORY)
	public Set<Story> findAll() {
		Session s = sf.getCurrentSession();

		return (Set<Story>) s.createCriteria(Story.class).list();

	}

	
	@Transactional(propagation = Propagation.MANDATORY)
	public Story save(Story story) {
		Session s = sf.getCurrentSession();

		s.saveOrUpdate(story);

		return story;
	}
}
