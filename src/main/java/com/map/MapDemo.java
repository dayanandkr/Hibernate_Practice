package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String arg[]) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		//Create question
		Question q1=new Question();
		q1.setQuestionId(1);
		q1.setQuestion("What is Java");
		
		//Create answer
		Answer a1=new Answer();
		a1.setAnswerId(11);
		a1.setAnswer("Java is a programming language");
		a1.setQuestion(q1);
		
		Answer a2=new Answer();
		a2.setAnswerId(12);
		a2.setAnswer("With the help of java we can create the software");
		a2.setQuestion(q1);
		
		Answer a3=new Answer();
		a3.setAnswerId(13);
		a3.setAnswer("Java has different types frame work");
		a3.setQuestion(q1);
		
		List<Answer> list= new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswer(list);
		
		
		
		
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		
//		 session.save(q1);
//		 session.save(a1);
//		 session.save(a2);
//		 session.save(a3);
		 
		tx.commit();
		
//		Question newQ = (Question)session.get(Question.class, 1);
//		System.out.println(newQ.getQuestion());
//		System.out.println(newQ.getAnswer().getAnswer());
		
		Question q = (Question)session.get(Question.class, 1);
		System.out.println(q.getQuestion());
		for(Answer a:q.getAnswer()) {
			System.out.println(a.getAnswer());
		}

		
		session.close();
		factory.close();
		
	}

}
