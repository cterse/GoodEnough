package com.ecom1.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecom1.hibernate.util.HibernateUtil;
import com.ecom1.models.Product;
import com.ecom1.models.Vendor;

public class VendorDAO {
	
	public static void main(String[] args) {
		getVendorByEmail("vendor@v.com");
	}
	
	public static int getVendorProductCount(String email) {
		return getProductsByVendor(email).size();
	}
	
	public static List getProductsByVendor(String email) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session newSession = factory.openSession();
		Transaction trans = newSession.beginTransaction();
		
		String query = "FROM Product p WHERE p.vendor.vendorEmail = :vendor_email";
		Query q = newSession.createQuery(query);
		q.setParameter("vendor_email", email);
		List<Product> newList = q.list();
		
		trans.commit();
		newSession.close();
		return newList;
	}
	
	public static int insertIntoVendor(Vendor v) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session newSession = factory.openSession();
		Transaction trans = newSession.beginTransaction();
		newSession.save(v);
		trans.commit();
		newSession.close();
		System.out.println("Successful");
		return 0;
	}
	
	public static List getVendors() {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session newSession = factory.openSession();
		Transaction trans = newSession.beginTransaction();
		String query = "FROM Vendor";
		Query q = newSession.createQuery(query);
		return q.list();
	}
	
	public static Vendor getVendorByEmail(String email) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Transaction trans = session.beginTransaction();
		String loginMappingQuery = "FROM Vendor v WHERE v.vendorEmail = :vendor_email";
		Query q = session.createQuery(loginMappingQuery);
		q.setParameter("vendor_email", email);
		List<Vendor> v = q.list();
		//System.out.println(v.get(0).getVendorEmail()+":"+v.get(0).getVendorName()+":"+v.get(0).getVendorPassword());
		return v.get(0);
	}
	
	public static Map<String, String> getVendorLoginMappings() {
		Map<String, String> extractedMappings = new HashMap<String, String>();
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Transaction trans = session.beginTransaction();
		String loginMappingQuery = "SELECT v.vendorEmail, v.vendorPassword FROM Vendor v";
		Query q = session.createQuery(loginMappingQuery);
		List<Object[]> list = q.list();
		
		trans.commit();
		session.close();
		
		for(Object[] v : list) {
			extractedMappings.put(v[0].toString(), v[1].toString());
		}
		//System.out.println(extractedMappings);
		return extractedMappings;
	}

}
