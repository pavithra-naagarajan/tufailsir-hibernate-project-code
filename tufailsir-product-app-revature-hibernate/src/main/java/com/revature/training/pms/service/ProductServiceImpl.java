package com.revature.training.pms.service;

import java.util.List;

import com.revature.pms.dao.ProductDAO;
import com.revature.pms.dao.ProductDAOImpl;
import com.revature.pms.model.Product;

//transaction
public class ProductServiceImpl implements ProductService {

	ProductDAO productDAO = new ProductDAOImpl();

	public boolean addProduct(Product product) {
		if (product.getPrice() < 0)
			return false;
		else
			return productDAO.addProduct(product);
	}

	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		//coding 
		return productDAO.deleteProduct(productId);
	}

	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.updateProduct(product);
	}

	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return productDAO.getProductById(productId);
	}

	public List<Product> getProductByName(String productName) {
		// TODO Auto-generated method stub
		return productDAO.getProductByName(productName);
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDAO.getAllProducts();
	}

	public boolean isProductExists(int productId) {
		// TODO Auto-generated method stub
		return productDAO.isProductExists(productId);
	}

}
