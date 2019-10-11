package com.revature.services;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.IUser;
import com.revature.models.User;
import com.revature.repositories.IUserRepository;

@Service
public class UserService implements IUserService {

	private IUserRepository userRepository;
	
	@Override
	public IUser findOne(int id) {
		return userRepository.findOne(id);
	}
	
	@Override
	public Set<IUser> findAll(){
		return userRepository.findAll();
	}
	
	@Override
	public IUser save(IUser user) {
		userRepository.save(user);
		
		return user;
	}
}
