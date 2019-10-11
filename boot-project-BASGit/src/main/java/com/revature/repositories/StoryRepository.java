package com.revature.repositories;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.IStory;
import com.revature.models.Story;

@Repository
public class StoryRepository implements IStoryRepository {

	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public IStory findOne(int id) {
		Session s = sf.getCurrentSession();
		return (IStory) s.get(Story.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.MANDATORY)
	public Set<IStory> findAll() {
		Session s = sf.getCurrentSession();

		return (Set<IStory>) s.createCriteria(Story.class).list();

	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public IStory save(IStory story) {
		Session s = sf.getCurrentSession();

		s.saveOrUpdate(story);

		return story;
	}
}
