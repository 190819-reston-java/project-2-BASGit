
package com.revature.repositories;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.lang.NonNull;

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
	private Date dateTime;
	
	@Column(name="from_user")
	private String from_user;
	
	@Column(name="to_user")
	private String to_user;
	
	@Column(name="message")
	private String message;

	public Messages(Date dateTime, String from_user, String to_user, String message) {
		super();
		// this.id = // TODO: is this needed? // Does this autogenerate? // TODO: Test
		this.dateTime = dateTime;
		this.from_user = from_user;
		this.to_user = to_user;
		this.message = message;
	}

	
//	public static void main(String[] args) {
//
//	}

}
