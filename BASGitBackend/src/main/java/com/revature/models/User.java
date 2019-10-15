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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
@Table(name = "users")
public class User implements Serializable{


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

	@JsonIgnore
	@OneToMany(mappedBy = "id", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private Set<Story> stories;

	public User() {
	}

	public User(int id, String username, String password, String avatarURL, boolean isAdmin, String fullname,
			Set<Story> stories) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.avatarURL = avatarURL;
		this.isAdmin = isAdmin;
		this.fullname = fullname;
		this.stories = stories;
	}

	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getUsername() {
		return username;
	}

	
	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getAvatarURL() {
		return avatarURL;
	}

	
	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}

	
	public boolean isAdmin() {
		return isAdmin;
	}

	
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	
	public String getFullname() {
		return fullname;
	}

	
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	
	public Set<Story> getStories() {
		return stories;
	}

	
	public void setStories(Set<Story> stories) {
		this.stories = stories;
	}
	
	

}
