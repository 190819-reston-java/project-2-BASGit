package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stories")
public class Story {

	@ManyToOne
	@JoinColumn(name = "authorID", nullable = false, insertable = false, updatable = false)
	private User user;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int storyID;
	@Column(name = "headline")
	private String headline;
	@Column(name = "body")
	private String body;
	@Column(name = "picture")
	private String picture;
	@Column(name = "authorID")
	private String authorID;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getStoryID() {
		return storyID;
	}

	public void setStoryID(int storyID) {
		this.storyID = storyID;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getAuthorID() {
		return authorID;
	}

	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}

	@Override
	public String toString() {
		return "Story [user=" + user + ", storyID=" + storyID + ", headline=" + headline + ", body=" + body
				+ ", picture=" + picture + ", authorID=" + authorID + "]";
	}
}
