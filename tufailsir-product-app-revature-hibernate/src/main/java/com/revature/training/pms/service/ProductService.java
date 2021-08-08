package com.revature.training.pms.service;

import java.util.List;

import com.revature.pms.model.Product;

public interface ProductService {
	public boolean addProduct(Product product);
	public boolean deleteProduct(int productId);
	public boolean updateProduct(Product product);
	public Product getProductById(int productId);
	public List<Product> getProductByName(String productName);
	public List<Product> getAllProducts();
	public boolean isProductExists(int productId);
}
