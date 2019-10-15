package com.revature.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "stories")
public class Story implements Serializable {

	private static final long serialVersionUID = -6136453420546306607L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "story_id")
	private int id;
	@Column
	private String body;
	@Column
	private String headline;
	@Column
	private String pictureURL;
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "user_id")
	private User author;


	public Story() {
	}

	public Story(int id, String body, String headline, String pictureURL, User author) {
		this.id = id;
		this.body = body;
		this.headline = headline;
		this.pictureURL = pictureURL;
		this.author = author;
	}
	
	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getBody() {
		return body;
	}

	
	public void setBody(String body) {
		this.body = body;
	}

	
	public String getHeadline() {
		return headline;
	}

	
	public void setHeadline(String headline) {
		this.headline = headline;
	}

	
	public String getPictureURL() {
		return pictureURL;
	}

	
	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	
	public User getAuthor() {
		return author;
	}

	
	public void setAuthor(User author) {
		this.author = author;
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((headline == null) ? 0 : headline.hashCode());
		result = prime * result + id;
		result = prime * result + ((pictureURL == null) ? 0 : pictureURL.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Story other = (Story) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (headline == null) {
			if (other.headline != null)
				return false;
		} else if (!headline.equals(other.headline))
			return false;
		if (id != other.id)
			return false;
		if (pictureURL == null) {
			if (other.pictureURL != null)
				return false;
		} else if (!pictureURL.equals(other.pictureURL))
			return false;
		return true;
	}

	
	public String toString() {
		return "Story [id=" + id + ", body=" + body + ", headline=" + headline + ", pictureURL=" + pictureURL + "]";
	}

}
