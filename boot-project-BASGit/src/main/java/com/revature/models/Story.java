package com.revature.models;

import java.io.Serializable;

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
public class Story implements Serializable, IStory {

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
	@ManyToOne
	@JoinColumn(name = "user_id")
	private IUser author;


	public Story() {
	}

	public Story(int id, String body, String headline, String pictureURL, IUser author) {
		this.id = id;
		this.body = body;
		this.headline = headline;
		this.pictureURL = pictureURL;
		this.author = author;
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
	public String getBody() {
		return body;
	}

	@Override
	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String getHeadline() {
		return headline;
	}

	@Override
	public void setHeadline(String headline) {
		this.headline = headline;
	}

	@Override
	public String getPictureURL() {
		return pictureURL;
	}

	@Override
	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	@Override
	public IUser getAuthor() {
		return author;
	}

	@Override
	public void setAuthor(IUser author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((headline == null) ? 0 : headline.hashCode());
		result = prime * result + id;
		result = prime * result + ((pictureURL == null) ? 0 : pictureURL.hashCode());
		return result;
	}

	@Override
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

	@Override
	public String toString() {
		return "Story [id=" + id + ", body=" + body + ", headline=" + headline + ", pictureURL=" + pictureURL + "]";
	}

}
