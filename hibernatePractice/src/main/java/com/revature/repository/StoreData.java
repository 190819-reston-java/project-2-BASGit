package com.revature.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.revature.model.Story;
import com.revature.model.User;

public class StoreData {
	public static void main(String[] args) {

		// Create typesafe ServiceRegistry object
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		User u1 = new User();
		
		u1 = session.get(User.class, "callen");
		
		u1.setEmail("newEmail");
		
		Story s1 = new Story();
		s1.setAuthorID(u1.getUsername());
		s1.setBody("This is a test story for the database!");
		s1.setHeadline("Local man updates story in database");
		
		session.save(u1);
		session.save(s1);
		
		t.commit();
		System.out.println("successfully saved");
		factory.close();
		session.close();

	}
}