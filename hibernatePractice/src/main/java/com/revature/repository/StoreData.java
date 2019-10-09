package com.revature.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
		
		u1.setUsername("callen");
		u1.setFirstName("Chris");
		u1.setLastName("Allen");
		u1.setPassword("testPassword");
		u1.setEmail("chris.allen070@gmail.com");
		
		session.save(u1);
		t.commit();
		System.out.println("successfully saved");
		factory.close();
		session.close();

	}
}