package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class UserDao {

	private HibernateTemplate template;
	
	private void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public void saveUser(User u) {
		template.save(u);
	}
	
	public void updateUser(User u) {
		template.update(u);
	}
	
	public void deleteUser(User u) {
		template.delete(u);
	}
	
	public void saveOrUpdateUser(User u) {
		template.saveOrUpdate(u);
	}
	
	public User getUserByUsername(String username) {
		User u = (User)template.get(User.class, username);
		return u;
	}
	
	public List<User> returnAllUsers(){
		List<User> list = new ArrayList<User>();
		list = template.loadAll(User.class);
		return list;
	}
}
