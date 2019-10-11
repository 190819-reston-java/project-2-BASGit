package com.revature.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "users")
public class User implements Serializable, IUser {


	private static final long serialVersionUID = 8567408101881674526L;

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String username;
	@Column(name = "user_password")
	private String password;
	@Column
	private String avatarURL;
	@Column
	private boolean isAdmin;
	@Column
	private String fullname;

	@OneToMany(mappedBy = "stories", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private Set<IStory> stories;

	public User() {
	}

	public User(int id, String username, String password, String avatarURL, boolean isAdmin, String fullname,
			Set<IStory> stories) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.avatarURL = avatarURL;
		this.isAdmin = isAdmin;
		this.fullname = fullname;
		this.stories = stories;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getAvatarURL() {
		return avatarURL;
	}

	@Override
	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}

	@Override
	public boolean isAdmin() {
		return isAdmin;
	}

	@Override
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String getFullname() {
		return fullname;
	}

	@Override
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Override
	public Set<IStory> getStories() {
		return stories;
	}

	@Override
	public void setStories(Set<IStory> stories) {
		this.stories = stories;
	}
	
	

}
