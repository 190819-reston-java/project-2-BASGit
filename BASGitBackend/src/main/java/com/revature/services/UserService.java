package com.revature.services;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	
	
	public User findOne(int id) {
		return userRepository.findOne(id);
	}
	
	
	public Set<User> findAll(){
		return userRepository.findAll();
	}
	
	
	public User save(User user) {
		userRepository.save(user);
		
		return user;
	}
}
