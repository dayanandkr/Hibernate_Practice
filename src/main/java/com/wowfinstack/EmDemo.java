package com.wowfinstack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	
public static void main(String arg[]) {
	Configuration cfg=new Configuration();
    cfg.configure("hibernate.cfg.xml");
    SessionFactory factory=cfg.buildSessionFactory();
    
    Student student1=new Student();
    student1.setId(1);
    student1.setName("Dayanand");
    student1.setCity("Sitamarhi");
    
    Certificate certificate=new Certificate();
    certificate.setCourse("Java");
    certificate.setDuration("2 month");
    student1.setCerti(certificate);
    
    
    
    Student student2=new Student();
    student2.setId(2);
    student2.setName("Basudev");
    student2.setCity("Motihari");
    
    Certificate certificate1=new Certificate();
    certificate1.setCourse("Spring Boot");
    certificate1.setDuration("1.5 month");
    student2.setCerti(certificate1);
    
    Session s=factory.openSession();
    
    Transaction tx=s.beginTransaction();
    s.save(student1);
    s.save(student2);
    
    tx.commit();
    s.close();
    factory.close();
    
    
    
    
}

}
