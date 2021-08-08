package com.revature.training.pms.service;

import java.util.List;

import com.revature.pms.dao.CustomerDAO;
import com.revature.pms.dao.impl.CustomerDAOImpl;
import com.revature.pms.model.Customer;
import com.revature.pms.model.Product;

public class CustomerServiceImpl implements CustomerService {

	CustomerDAO customerDAO = new CustomerDAOImpl();
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.addCustomer(customer);
	}

	public boolean deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		return customerDAO.deleteCustomer(customerId);
	}

	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.updateCustomer(customer);
	}

	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomerById(customerId);
	}

	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}

	public boolean isCustomerExists(int customerId) {
		// TODO Auto-generated method stub
		return customerDAO.isCustomerExists(customerId);
	}

	public int viewBalance(int customerId) {
		// TODO Auto-generated method stub
		return customerDAO.viewBalance(customerId);
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
