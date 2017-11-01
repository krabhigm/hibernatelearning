package com.learning.Hibernate_learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App_Embaddable {
	
	public static void main( String[] args )
    {
		Name nm = new Name();
		nm.setFname("Abhishek");
		nm.setMname("Kumar");
		nm.setLname("Gupta");
		
        Student s1 = new Student();
        s1.setRoll(101);
        s1.setName(nm);
        s1.setMark(50.00);
        
        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class);  // if we use default name of hibernate-configuration(hibernate.cfg.xml) then we don't have to provide file name in configure()
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(s1); // to save value in DB
         
        tx.commit();
    }

}
