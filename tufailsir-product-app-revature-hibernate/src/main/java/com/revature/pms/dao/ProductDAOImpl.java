package com.revature.pms.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.revature.pms.model.Product;
import com.revature.pms.util.HibernateUtil;

public class ProductDAOImpl implements ProductDAO {

	private static Logger logger = Logger.getLogger("ProductDAOImpl");

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();

	// THis will add product in DB
	public boolean addProduct(Product product) {
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		return true;
	}

	// 1
	public boolean deleteProduct(int productId) {
		Transaction transaction = session.beginTransaction();
		Product product = new Product();
		product.setProductId(productId);
		session.delete(product);
		transaction.commit();
		return true;

	}

	//
	public boolean updateProduct(Product product) {
		Transaction transaction = session.beginTransaction();
		session.update(product);
		transaction.commit();
		return true;
	}

	// 3
	// 3 Lakme 7 7 good//tested and worked
	public Product getProductById(int productId) {
		Product product = (Product) session.get(Product.class, productId);
		return product;
	}

	// tested
	public List<Product> getProductByName(String productName) {
		// select * from new_products where productName = 'Aroma'
		Query query = session
				.createQuery("from com.revature.pms.model.Product where productName = '" + productName + "'");
		return query.list();
	}

	// tested
	public List<Product> getAllProducts() {
		Query query = session.createQuery("from com.revature.pms.model.Product");
		return query.list();
	}

	public boolean isProductExists(int productId) {
		Product product = (Product) session.get(Product.class, productId);	
		if(product == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public List<Product> getProductByNameAndFilterByPrice(String productName, int lowerCost, int upperCost) {
		//Criteria in hibernate
		
		//select * from product
		Criteria criteria = session.createCriteria(Product.class);
		List<Product> products1 = criteria.list();
		
		//select * from product where productName = ?
		Criteria criteria2 = session.createCriteria(Product.class);
		criteria2.add(Restrictions.eq("productName", productName));
		List<Product> products2 = criteria.list();
		
		//select * from product where productName = ? and price between lowerCost and upperCost
		Criteria criteria3 = session.createCriteria(Product.class);
		criteria3.add(Restrictions.like("productName", productName));
		criteria3.add(Restrictions.between("price", lowerCost, upperCost));
		List<Product> products3 = criteria3.list();
		
		return products3;
	}
}
