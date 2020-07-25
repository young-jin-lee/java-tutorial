package com.tutorial.web.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/index")
public class IndexController extends HttpServlet{
	
	@Override
	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException ,java.io.IOException {
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	};
}
