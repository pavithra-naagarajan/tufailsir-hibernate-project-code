package com.revature.training.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pms.dao.ProductDAO;
import com.revature.pms.dao.ProductDAOImpl;
import com.revature.pms.model.Product;
import com.revature.training.pms.service.ProductService;
import com.revature.training.pms.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private static ProductController productController = new ProductController();
	
	public static ProductController getInstance() {
		return productController;
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		String productName = request.getParameter("productName");
		
		if(productName.startsWith("A"))
			response.sendRedirect("Home.html");
		int quantityOnHand = Integer.parseInt(request.getParameter("quantityOnHand"));
		int price = Integer.parseInt(request.getParameter("price"));
		String comments = request.getParameter("comments");

		Product product = new Product(productId, productName, quantityOnHand, price, comments);
		
		ProductService productService = new ProductServiceImpl();
		

		productService.addProduct(product);
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2> Product details entered by you is :");
		out.println("<h2>Product Id : "+ productId);
		out.println("Product Name : "+ productName);
		out.println("Quantity  : "+ quantityOnHand);
		out.println("Price : "+ price);
		out.println("Comments  : "+ comments);
		
		out.println("<br/><br/><a href=Home.html>Home</a>");

		out.println("</body></html>");
		
	}

}
