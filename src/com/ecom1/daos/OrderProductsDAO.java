package com.ecom1.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecom1.hibernate.util.HibernateUtil;
import com.ecom1.models.OrderProducts;
import com.ecom1.models.Product;

public class OrderProductsDAO 
{
	public static int insertIntoOrderProducts(OrderProducts op)
	{
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session newSession = factory.openSession();
		Transaction trans = newSession.beginTransaction();
		newSession.save(op);
		
		trans.commit();
		newSession.close();
		System.out.println("Successful");
		return 0;
	}
	
}
