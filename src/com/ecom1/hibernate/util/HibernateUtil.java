package com.ecom1.hibernate.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ecom1.models.Customer;

public class HibernateUtil {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session newSession = factory.openSession();
		Transaction trans = newSession.beginTransaction();
		trans.commit();
		newSession.close();
		System.out.println("Util main() successful");
	}
	
	public static SessionFactory getSessionFactory() {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		return factory;
	}

}
