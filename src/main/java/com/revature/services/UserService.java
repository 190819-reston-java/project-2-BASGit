package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.model.UserDao;

@Service
public class UserService {

	private List<User> users = new ArrayList<User>();
	private UserDao udao;

	public UserService() {
		users = udao.returnAllUsers();
	}

	public User findOne(String username) {
		for (User u : users) {
			if (u.getUsername() == username) {
				return u;
			}
		}
		return null;
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public boolean exists(String username) {
		if (findOne(username) != null) {
			return true;
		}
		return false;
	}
	
	public User upsert(User u) {
		if(exists(u.getUsername())) {
			udao.updateUser(u);;
		}
		else {
			udao.saveUser(u);
		}
		
		return u;
	}

}
