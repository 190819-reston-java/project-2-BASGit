package com.revature.repositories;

import java.util.Set;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;

@Repository
public class UserRepository  {
	
	@Autowired
	private SessionFactory sf;
	

	
	@Transactional(propagation = Propagation.MANDATORY)
	public User findOne(int id) {
		Session s = sf.getCurrentSession();
		return (User) s.get(User.class, id);
	}

	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.MANDATORY)
	public Set<User> findAll(){
		Session s = sf.getCurrentSession();
		
		return (Set<User>) s.createCriteria(User.class).list();
		
	}

	
	@Transactional(propagation = Propagation.MANDATORY)
	public User save(User user) {
		Session s = sf.getCurrentSession();
		
		s.saveOrUpdate(user);
		
		return user;
	}
}
