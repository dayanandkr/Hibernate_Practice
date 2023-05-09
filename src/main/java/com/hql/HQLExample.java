package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.wowfinstack.Student;

public class HQLExample {
	
	public static void main(String arg[]) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session s=factory.openSession();
		
		//HQl
		//Syntax : from Entity_name
		
		String query="from Student where city=:x";
		
		Query q= s.createQuery(query);
		
		q.setParameter("x","Motihari");
		
		List<Student>  list=q.list();
		
		for(Student student:list) {
			System.out.println(student.getName()+" : "+ student.getCerti().getCourse() );
		}
		
		System.out.println("-------------------------------");
		Transaction tx=s.beginTransaction();
		
		//Delete Query
//		Query q1=s.createQuery("delete from Student s where s.city=:c");
//		q1.setParameter("c", "dd");
//		int r=q1.executeUpdate();
//		System.out.println("Deleted");
//		System.out.println(r);
		
		//Update Query
		Query q2=s.createQuery("update Student set city=:c where city=:n");
		q2.setParameter("c", "abc");
		q2.setParameter("n", "xyz");
		int r=q2.executeUpdate();
		System.out.println(r+" Oject update");
		
		//How to execute join query
		Query q3=s.createQuery("select q.question, q.questionId, a.answer from Question as q INNER JOIN q.answer as a");
		
		List<Object []> list3=q3.getResultList();
		
		for(Object [] arr: list3) {
			System.out.println(Arrays.toString(arr));
		}
		tx.commit();
		
		s.close();
		factory.close();
	}

}
