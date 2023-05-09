package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.wowfinstack.Student;

public class HQlPegination {
	
	public static void main(String arg[]) {
	
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session s=factory.openSession();
		
		Query query=s.createQuery("from Student");
		
		// Implementaion using hibernate
		
		query.setFirstResult(7);
		
		query.setMaxResults(5);
		
		List<Student> list=query.list();
		
		for(Student st : list) {
			System.out.println(st.getId()+" : "+st.getName()+" : "+st.getCity());
		}
		
		
		
		factory.close();
		
	}

}
