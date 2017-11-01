package com.learning.Hibernate_learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Employee e1 = new Employee();
        Employee e2 = null;
        e1.setEid(50);
        e1.setName("Test50");
        e1.setSalary(500000.00);
        
        Configuration conf = new Configuration().configure().addAnnotatedClass(Employee.class);  // if we use default name of hibernate-configuration(hibernate.cfg.xml) then we don't have to provide file name in configure()
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(e1); // to save value in DB
       
        
//        e2 = (Employee)session.get(Employee.class, 1);   /*to get data from DB, in this case we don't have to create object */
//        System.out.println(e2);
        
     
        
        session.getTransaction().commit();
        session.close();
    }
}
