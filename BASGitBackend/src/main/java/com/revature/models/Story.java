package com.revature.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "user_id")
	private User author;
	@Column
	private User to_user;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_time")
	private Timestamp dateTime;

	public Story() {
	}

	public Story(int id, String body, String headline, String pictureURL, User author, User to_user, Timestamp ts) {
		this.id = id;
		this.body = body;
		this.headline = headline;
		this.pictureURL = pictureURL;
		this.author = author;
		this.to_user = to_user;
		this.dateTime = ts;
	}

	public User getTo_user() {
		return this.to_user;
	}

	public void setTo_user(User to_user) {
		this.to_user = to_user;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getHeadline() {
		return this.headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getPictureURL() {
		return this.pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	public User getAuthor() {
		return this.author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Timestamp getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.body == null) ? 0 : this.body.hashCode());
		result = prime * result + ((this.headline == null) ? 0 : this.headline.hashCode());
		result = prime * result + this.id;
		result = prime * result + ((this.pictureURL == null) ? 0 : this.pictureURL.hashCode());
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
		if (this.body == null) {
			if (other.body != null)
				return false;
		} else if (!this.body.equals(other.body))
			return false;
		if (this.headline == null) {
			if (other.headline != null)
				return false;
		} else if (!this.headline.equals(other.headline))
			return false;
		if (this.id != other.id)
			return false;
		if (this.pictureURL == null) {
			if (other.pictureURL != null)
				return false;
		} else if (!this.pictureURL.equals(other.pictureURL))
			return false;
		if(!this.to_user.equals(other.to_user)) {
			return false;
		}
		if (!this.dateTime.equals(other.dateTime)){
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Story [id=" + this.id + ", body=" + this.body + ", headline=" + this.headline + ", pictureURL="
				+ this.pictureURL + ", author=" + this.author + ", to_user=" + this.to_user + ", dateTime="
				+ this.dateTime + "]";
	}

//	public String toString() {
//		return "Story [id=" + id + ", body=" + body + ", headline=" + headline + ", pictureURL=" + pictureURL + "]";
//	}

}
