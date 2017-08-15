package com.ecom1.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecom1.hibernate.util.HibernateUtil;
import com.ecom1.models.Customer;

public class CustomerDAO {

	public static void main(String[] args) {
		/*Customer c = new Customer();
		c.setCustomerAddress("bbbb");
		c.setCustomerEmail("uvw@xyz.com");
		c.setCustomerFirstName("fname2");
		c.setCustomerLastName("lname2");
		c.setCustomerPassword("password");
		c.setCustomerPhone("56418789");
		System.out.println("insert status: "+insertIntoCustomer(c));
		Map<String, String> extractedMappings = getCustomerLoginMappings();
		System.out.println("here"+extractedMappings);
		System.out.println(extractedMappings.get("hdbfdbfkjdsbfkbsdkjfb"));  //returns null
		*/
	}
	
	public static int insertIntoCustomer(Customer c) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session newSession = factory.openSession();
		Transaction trans = newSession.beginTransaction();
		
		//c.setCustomerId(null);
		/*c.setCustomerFirstName(c.getCustomerFirstName());
		c.setCustomerLastName(c.getCustomerLastName());
		c.setCustomerEmail(c.getCustomerEmail());
		c.setCustomerPhone(c.getCustomerPhone());
		c.setCustomerAddress(c.getCustomerAddress());
		c.setCustomerPassword(c.getCustomerPassword());
		c.setCustomerRegDate(c.getCustomerRegDate());*/
		newSession.save(c);
		
		trans.commit();
		newSession.close();
		System.out.println("Successful");
		return 0;
	}
	
	public static Map<String, String> getCustomerLoginMappings() {
		Map<String, String> extractedMappings = new HashMap<String, String>();
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Transaction trans = session.beginTransaction();
		String loginMappingQuery = "SELECT c.customerEmail, c.customerPassword FROM Customer c";
		Query q = session.createQuery(loginMappingQuery);
		List<Object[]> list = q.list();
		
		trans.commit();
		session.close();
		
		for(Object[] c : list) {
			extractedMappings.put(c[0].toString(), c[1].toString());
		}
		//System.out.println(extractedMappings);
		return extractedMappings;
	}
	
	public static List<String> checkCredentials(String username, String password){
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session newSession = factory.openSession();
		Transaction trans = newSession.beginTransaction();
		Query q=newSession.createQuery("select c.customerEmail,c.customerPassword from Customer c where c.customerEmail=username and c.customerPassword=password");
		
		return (List<String>) q.list();
		
	}
}

