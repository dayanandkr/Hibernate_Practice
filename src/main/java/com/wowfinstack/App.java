package com.wowfinstack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started" );
        
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        
        //Create Student
        Student s1=new Student();
        s1.setId(1);
        s1.setName("Dayanand");
        s1.setCity("Sitamarhi");
        
        Student s2=new Student();
        s2.setId(3);
        s2.setName("Basudev");
        s2.setCity("Motihari");
        
        Student s3=new Student();
        s3.setId(4);
        s3.setName("Atul");
        s3.setCity("Samstipur");
        
        Student s4=new Student();
        s4.setId(5);
        s4.setName("Raj Pathak");
        s4.setCity("Gopalganj");
        
        
        
        System.out.println(s1);
        //System.out.println(factory.isClosed());
        
        Session session =factory.openSession();
        
        Transaction tx=session.beginTransaction();
        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);
        tx.commit();
        session.close();
        
        
    }
}
