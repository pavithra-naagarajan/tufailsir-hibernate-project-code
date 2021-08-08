package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revature.training.pms.controller.Welcome;

public class RequestHelper {
	
	private RequestHelper() {}
	
	public static Object process(HttpServletRequest request) {
		switch(request.getRequestURI()) {
		case "welcome.do":
			return new Object();
			//return Welcome.getInstance().login(request);
		/*
		 * case "/FrontController/logout.do": return
		 * LoginControllerAlpha.getInstance().logout(request); case
		 * "/FrontController/register.do": return
		 * CustomerControllerAlpha.getInstance().register(request); case
		 * "/FrontController/getAll.do": return
		 * CustomerControllerAlpha.getInstance().getAllCustomers(request);
		 */
		default:
			return "not-implemented.html";
		}
	}
}