package com.revature.repositories;

import java.util.HashSet;
import java.util.Set;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;

@Repository
public class UserRepository  {
	
	@Autowired
	private SessionFactory sf;
	

	
	@Transactional
	public User findOne(int id) {
		Session s = sf.getCurrentSession();
		return (User) s.get(User.class, id);
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findAll(){
		Session s = sf.getCurrentSession();
		
		return new HashSet<User>(s.createCriteria(User.class).list());
		
	}

	
	@Transactional
	public User save(User user) {
		Session s = sf.getCurrentSession();
		
		s.saveOrUpdate(user);
		
		return user;
	}


	@Transactional
	public User findByUserName(String username) {
		Session s = sf.getCurrentSession();
		
		return (User) s.createCriteria(User.class)
				.add(Restrictions.eq("username", username))
				.list().get(0);
	}
}
