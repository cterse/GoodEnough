package com.ecom1.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecom1.hibernate.util.HibernateUtil;
import com.ecom1.models.Order;

public class OrderDAO
{
	public static int insertIntoOrder(Order o)
	{
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session newSession = factory.openSession();
		Transaction trans = newSession.beginTransaction();
		newSession.save(o);
		
		trans.commit();
		newSession.close();
		System.out.println("Successful");
		return 0;
	}
	

}
