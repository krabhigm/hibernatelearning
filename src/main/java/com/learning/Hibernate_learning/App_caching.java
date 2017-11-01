package com.learning.Hibernate_learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App_caching {
	
	public static void main (){
		

        Employee e2 = null;
        
        Configuration conf = new Configuration().configure().addAnnotatedClass(Employee.class);  // if we use default name of hibernate-configuration(hibernate.cfg.xml) then we don't have to provide file name in configure()
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
    /*    below is by default 1st level of caching, since we are fetching same data in same session, so there will be only one query execute,
        2nd time it will get data from cache.*/
        
//        e2 = (Employee)session.get(Employee.class, 1);   /*to get data from DB, in this case we don't have to create object */
//        System.out.println(e2);
        
//        e2 = (Employee)session.get(Employee.class, 1);   /*to get data from DB, in this case we don't have to create object */
//        System.out.println(e2);
        
        
//        tx.commit();
//        session.close();
        
        
        
        /*    if we use two different session for same data, then there will two query  */
        
        
        
        Session session1 = sf.openSession();
        Transaction tx1 = session1.beginTransaction();
        e2 = (Employee)session1.get(Employee.class, 1);  
        System.out.println(e2);
        tx1.commit();
        session1.close();
        
        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();
        e2 = (Employee)session2.get(Employee.class, 1);   
        System.out.println(e2);
        tx2.commit();
        session2.close();
        
        
        
	}

}
