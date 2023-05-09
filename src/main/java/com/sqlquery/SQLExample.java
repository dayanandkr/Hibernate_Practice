package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.wowfinstack.Student;

public class SQLExample {
	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session s=factory.openSession();
		
		String q="select * from student";
		
		NativeQuery nq = s.createSQLQuery(q);
		
		List<Object[]> list=nq.list();
		for(Object[] st:list) {
			//System.out.println(Arrays.toString(st));
			System.out.println(st[4]+" : "+st[3]);
		}
		
		
		s.close();
		factory.close();
	}

}
