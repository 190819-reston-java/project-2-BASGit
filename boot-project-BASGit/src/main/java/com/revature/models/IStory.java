package com.revature.models;

public interface IStory {

	int getId();

	void setId(int id);

	String getBody();

	void setBody(String body);

	String getHeadline();

	void setHeadline(String headline);

	String getPictureURL();

	void setPictureURL(String pictureURL);

	IUser getAuthor();

	void setAuthor(IUser author);

	int hashCode();

	boolean equals(Object obj);

	String toString();

}