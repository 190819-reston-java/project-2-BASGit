
package com.revature.repositories;

//import java.sql.Date;
import java.sql.Timestamp;
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.lang.NonNull;

//import com.revature.models.Story;

// Ignore this file for now?

@Entity
@Table(name="Messages_Table")
public class Messages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	@Column(name="id")
	private Integer ID;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_time")
	private Timestamp dateTime;
	
	@Column(name="from_user")
	private String from_user;
	
	@Column(name="to_user")
	private String to_user;
	
	@Column(name="message")
	private String message;

	public Messages(Timestamp timestamp, String from_user, String to_user, String message) {
		super();
		// this.id = // TODO: is this needed? // Does this autogenerate? // TODO: Test
		this.dateTime = timestamp;
		this.from_user = from_user;
		this.to_user = to_user;
		this.message = message;
	}

	public Integer getID() {
		return this.ID;
	}

	public void setID(Integer iD) {
		this.ID = iD;
	}

	public Timestamp getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public String getFrom_user() {
		return this.from_user;
	}

	public void setFrom_user(String from_user) {
		this.from_user = from_user;
	}

	public String getTo_user() {
		return this.to_user;
		
	}

	public void setTo_user(String to_user) {
		this.to_user = to_user;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Messages [ID=" + this.ID + ", dateTime=" + this.dateTime + ", from_user=" + this.from_user + ", to_user=" + this.to_user
				+ ", message=" + this.message + "]";
	}

	public static void main(String[] args) {
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//LocalDateTime now = LocalDateTime.now();
		//Instant instant = Instant.now();
		//Date date = new Date();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    //Instant instant2 = timestamp.toInstant();
		Messages me = new Messages(timestamp, "from_me", "to_me", "me_message_me");
		System.out.println(me.toString());
	}

}

