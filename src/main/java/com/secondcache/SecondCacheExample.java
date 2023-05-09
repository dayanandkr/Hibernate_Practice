package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wowfinstack.Student;

public class SecondCacheExample {
	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		//Open Session 1
		Session s1=factory.openSession();
		Student student=s1.get(Student.class, 1);
		System.out.println(student);
		s1.close();
		//Open Session 2
		Session s2=factory.openSession();
		Student student1=s2.get(Student.class, 1);
		System.out.println(student1);
		s2.close();
	}

}
