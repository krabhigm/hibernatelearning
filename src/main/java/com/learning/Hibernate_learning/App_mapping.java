package com.learning.Hibernate_learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App_mapping {
	
	public static void main(String args[]){
		
		Laptop laptop = new Laptop();
		laptop.setLid(101);
		laptop.setLname("Mac");
		
		
		User u = new User();
		u.setUid(1);
		u.setName("Abhishek");
		u.getLaptop().add(laptop);
		laptop.getUser().add(u);
		
		 
		Configuration cfg = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();
		session.save(u);
		session.save(laptop); 
		ts.commit();
		
		
	}

}
