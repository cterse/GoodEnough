package com.ecom1.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecom1.hibernate.util.HibernateUtil;
import com.ecom1.models.Product;

public class ProductDAO 
{
	public static void main(String args[]) {
		Map<String, String> filters = new HashMap<String, String>();
		filters.put("productGender", "male");
		filters.put("productCategory", "Topwear");
		List results = getProductsByFilters(filters);
	}
	
	public static Product getProductById(int pid) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session newSession = factory.openSession();
		Transaction trans = newSession.beginTransaction();
		
		String query = "FROM Product p WHERE p.productId = :pid";
		Query q = newSession.createQuery(query);
		q.setParameter("pid", pid);
		Product p = (Product)q.list().get(0);
		
		trans.commit();
		newSession.close();
		
		return p;
	}
	
	public static List getProductsByFilters(Map<String, String> filters) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session newSession = factory.openSession();
		Transaction trans = newSession.beginTransaction();
		
		String query = "FROM Product p WHERE ";
		
		Set<String> filterNames = filters.keySet();
		Iterator<String> setIt = filterNames.iterator();
		while(setIt.hasNext()) {
			String filter = setIt.next();
			if(filters.containsKey(filter)) {
				query += "p." + filter +" = ";
			}
			if(!(filter.equals("productId") || filter.equals("productPrice"))) {
				query += "\'" + filters.get(filter) + "\'";
			} else {
				query += filters.get(filter);
			}
			if(setIt.hasNext()) {
				query += " AND";
			}
			query += " ";
		}
		System.out.println(query);
		
		Query q = newSession.createQuery(query);
		return q.list();
	}
	
	public static int insertIntoProduct(Product p,int quantity)
	{
		List<Product> pList = new ArrayList<Product>();
		for(int i=0; i<quantity; i++) {
			pList.add(new Product(p));
		}
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session newSession = factory.openSession();
		Transaction trans = newSession.beginTransaction();
		
		for(int i=0; i<quantity; i++) {
			newSession.save(pList.get(i));
		}	
		trans.commit();
		newSession.close();
		System.out.println("Successful");
		return 0;
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
	
}
