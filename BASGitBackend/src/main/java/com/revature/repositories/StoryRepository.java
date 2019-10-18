package com.revature.repositories;

import java.sql.Timestamp;
import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;

//import javax.persistence.Column;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Story;
import com.revature.models.User;

@Repository
public class StoryRepository {

	@Autowired
	private SessionFactory sf;

	@Transactional
	public Story findOne(int id) {
		Session s = this.sf.getCurrentSession();
		return (Story) s.get(Story.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<Story> findAll() {
		Session s = this.sf.getCurrentSession();

		return new ArrayList<Story>(s.createCriteria(Story.class).list());

	}

	@Transactional
	public Story save(Story story) {
		Session s = this.sf.getCurrentSession();

		s.saveOrUpdate(story);

		return story;
	}
//	@Temporal(TemporalType.DATE)
//	@Column(name="date_time")
//	private Timestamp dateTime;
	public Story createNew(Story story, User u, User t, Timestamp ts) {
		Session s = this.sf.getCurrentSession();

		story.setAuthor(u);
		story.setTo_user(t);
		story.setDateTime(ts);

		s.saveOrUpdate(story);

		return story;

	}
}
