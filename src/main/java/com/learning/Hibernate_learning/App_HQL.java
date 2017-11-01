package com.learning.Hibernate_learning;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App_HQL {

	public static void main(String[] args){
	
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session  = sf.openSession();
        Transaction tx = session.beginTransaction();
        
       /* 
       * Add 50 entry in table
       * 
       * Random r = new Random();
       * for(int i=0; i<50; i++){
        	
        	Employee e = new Employee();
        	
        	e.setEid(i);
        	e.setName("Test"+i);
        	e.setSalary(r.nextInt(10000000));
        	session.save(e);
        }*/
        
        
        // ******  HQL  ************
/*   To fetch all rows*/
//        Query q = session.createQuery("from Employee where salary > 5000000");
//        List<Employee> emp = q.list();
//        for(Employee e: emp){
//        	System.out.println(e);
//        }

        
/*        to get specific column
*///         Query q1 = session.createQuery("select name,salary from Employee where eid = 25");
//         Object[] ob = (Object[])q1.uniqueResult(); 
//         for(Object empl: ob){
//        	 System.out.println(empl);
//         }
         
        // Get all specific column
        
//         Query q2 = session.createQuery("select name,salary from Employee");
//         List<Object[]> obs = (List<Object[]>)q2.list(); 
//         for(Object[] empl: obs){
//        	 System.out.println(empl[0]+" "+empl[1]);
//         }
         
         
        
         // ***** SQL  *****  we can also use SQL here
         
       
        
        //here we will get object of Employee,
        //							    SQLQuery sql = session.createSQLQuery("Select * from Employee");
        		//				        List emp1 = sql.list();
        		//				        for(Object e: emp1){
        		//				        	System.out.println(e);
        		//				        }
        
        // solution
//	            SQLQuery sql = session.createSQLQuery("Select * from Employee");
//		        sql.addEntity(Employee.class);    // to specify what type of value we are getting
//		        List <Employee> emp1 = sql.list();
//		        for(Employee e:emp1){
//		        	System.out.println(e);
//		        }
        
        
//        Now to get below data
		SQLQuery sql = session.createSQLQuery("Select name, salary from Employee");
		sql.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List emp = sql.list();
		
		for(Object o: emp){
			Map m =(Map)o;
			System.out.println(m.get("name")+" "+m.get("salary"));
		}
        
        tx.commit();
        session.close();
	}

	


}
