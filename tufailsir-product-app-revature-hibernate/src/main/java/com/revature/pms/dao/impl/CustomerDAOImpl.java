package com.revature.pms.dao.impl;

import java.util.List;


import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.revature.pms.dao.CustomerDAO;
import com.revature.pms.model.Customer;
import com.revature.pms.model.Product;
import com.revature.pms.util.HibernateUtil;

public class CustomerDAOImpl implements CustomerDAO {

	private static Logger logger = Logger.getLogger("CustomerDAOImpl");
	
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	
	public boolean addCustomer(Customer customer) {
		Transaction transaction = session.beginTransaction();
		session.save(customer);
		transaction.commit();
		return true;
	}

	public boolean deleteCustomer(int customerId) {
		Transaction transaction = session.beginTransaction();
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		session.delete(customer);
		transaction.commit();
		return true;
	}

	public boolean updateCustomer(Customer customer) {
		Transaction transaction = session.beginTransaction();
		session.update(customer);
		transaction.commit();
		return true;
	}

	public Customer getCustomerById(int customerId) {
		Customer customer =  (Customer) session.load(Customer.class, customerId);
		return customer;
	}

	public List<Customer> getCustomers() {
		Query query = session.createQuery("from com.revature.pms.model.Customer");
		List<Customer> customers = query.list();
		System.out.println(customers);
		return customers;
	}

	public boolean isCustomerExists(int customerId) {
		Customer customer =  (Customer) session.get(Customer.class, customerId);
		if(customer ==null)
			return false;
		else
			return true;
	}

	//HQL - Hibernate Query Language
	//instead of working on tables and columns in works on POJOS and properties
	public int viewBalance(int customerId) {
		Query query = session.createQuery("select balance from com.revature.pms.model.Customer where customerId = "+customerId);
		int balance = Integer.parseInt( "query.list().get(0)");
		logger.info("The balance for :"+customerId + " is "+balance);
		return balance;
	}

	public int deposit(int amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int withdraw(int amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean transferAmount(int senderId, int receiverId, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
