package com.revature.training.pms.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.pms.model.Customer;

public class CustomerServiceImplTest {

	CustomerService customerService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		customerService = new CustomerServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddCustomer() {
		Customer customer = new Customer(122, "Arun", "neha@123", 5000, "8867205331", "tufailahmedkhan@gmail.com", new Date());
		assertEquals(true, customerService.addCustomer(customer));
	}

	@Test
	public void testDeleteCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCustomerById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCustomers() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsCustomerExists() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewBalance() {
		int customerId=2;		
		assertEquals(5000, customerService.viewBalance(customerId));
	}

	@Test
	public void testDeposit() {
		fail("Not yet implemented");
	}

	@Test
	public void testWithdraw() {
		fail("Not yet implemented");
	}

	@Test
	public void testTransferAmount() {
		fail("Not yet implemented");
	}

}
