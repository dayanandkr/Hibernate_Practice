package com.casecade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class casecadeExample {
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Question q1=new Question();
		q1.setQuestionId(3462);
		q1.setQuestion("What is Swing... ");
		
		Answer a1=new Answer(3221,"Swing is Java framework");
		Answer a2=new Answer(3245,"Second answer");
		Answer a3=new Answer(3298,"Third answer");
		List<Answer> list=new ArrayList<Answer>();	
		list.add(a1);
		list.add(a2);
		list.add(a3);
		q1.setAnswer(list);
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		s.save(q1);
		tx.commit();
		
		
		s.close();
		factory.close();
	}

}
