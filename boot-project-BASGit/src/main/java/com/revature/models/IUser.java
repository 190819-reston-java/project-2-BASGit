package com.revature.models;

import java.util.Set;

public interface IUser {

	int getId();

	void setId(int id);

	String getUsername();

	void setUsername(String username);

	String getPassword();

	void setPassword(String password);

	String getAvatarURL();

	void setAvatarURL(String avatarURL);

	boolean isAdmin();

	void setAdmin(boolean isAdmin);

	String getFullname();

	void setFullname(String fullname);

	Set<IStory> getStories();

	void setStories(Set<IStory> stories);

}