package com.wowfinstack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	
	public static void main(String arg[]) {
		//get, fetch
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        
        //get student -3
       Student student= (Student)session.get(Student.class, 3);
       System.out.println(student);
        
        
        
        session.close();
        factory.close();
	}

}
