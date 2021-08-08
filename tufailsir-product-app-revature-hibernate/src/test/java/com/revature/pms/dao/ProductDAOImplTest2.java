package com.revature.pms.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.pms.model.Product;

public class ProductDAOImplTest2 {

	ProductDAO productDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		productDAO = new ProductDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
		productDAO = null;
	}
	
	@Test
	public void testGetProductByNameAndFilterByPrice() {
		List<Product> searchResult = productDAO.getProductByNameAndFilterByPrice("Lakme", 10, 15);
		
		assertEquals(1, searchResult.size());
	}

}
