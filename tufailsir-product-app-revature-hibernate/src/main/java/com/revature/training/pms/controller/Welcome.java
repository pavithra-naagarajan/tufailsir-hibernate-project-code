package com.revature.training.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private static Welcome welcome = new Welcome();
	
	public static Welcome getInstance() {
		return welcome;
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    int counter=19981;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		counter++;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>Hi, You have logged in at : "+ new java.util.Date());
		out.println("<br/>You are user number : "+ counter);
		out.println("<br/><a href=Demo?counter="+counter+">Demo</a>");
		out.println("</body></html>");
	}
}
