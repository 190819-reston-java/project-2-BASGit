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
	@JoinColumn(name="authorID", nullable = false, insertable = false, updatable = false)
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
}
