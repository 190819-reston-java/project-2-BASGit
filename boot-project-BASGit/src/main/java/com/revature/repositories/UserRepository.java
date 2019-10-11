package com.revature.repositories;

import java.util.Set;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.IUser;
import com.revature.models.User;

@Repository
public class UserRepository implements IUserRepository {
	
	@Autowired
	private SessionFactory sf;
	

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public IUser findOne(int id) {
		Session s = sf.getCurrentSession();
		return (IUser) s.get(User.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.MANDATORY)
	public Set<IUser> findAll(){
		Session s = sf.getCurrentSession();
		
		return (Set<IUser>) s.createCriteria(User.class).list();
		
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public IUser save(IUser user) {
		Session s = sf.getCurrentSession();
		
		s.saveOrUpdate(user);
		
		return user;
	}
}
