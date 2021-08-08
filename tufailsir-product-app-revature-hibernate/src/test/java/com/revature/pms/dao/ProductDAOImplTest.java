package com.revature.pms.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.pms.model.Product;

public class ProductDAOImplTest {

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
	public void testAddProduct() {
		Product product = new Product(1991, "MI Laptop", 48000, 20, "Awesome");
		assertEquals(true, productDAO.addProduct(product));	}

	@Test
	public void testDeleteProduct() {
		int productId=2;
		assertEquals(true, productDAO.deleteProduct(productId));
	}

	@Test
	public void testUpdateProduct() {
		int proudctId = 1;
		Product product = new Product(proudctId, "MI Laptop", 48000, 20, "Awesome");
		product.setProductId(proudctId);
		assertEquals(true, productDAO.updateProduct(product));

	}

	@Test
	public void testGetProductById() {
		int productId=3;
		Product product = productDAO.getProductById(productId);
		assertNotNull(product);
	}

	@Test
	public void testGetProductByName() {
		
		List<Product> products = productDAO.getProductByName("Lakme");
		assertEquals(3, products.size());
	}

	@Test
	public void testGetAllProducts() {
		List<Product> products = productDAO.getAllProducts();
		assertEquals(2, products.size());
	}

	@Test
	public void testIsProductExists() {
		fail("Not yet implemented");
	}

}
