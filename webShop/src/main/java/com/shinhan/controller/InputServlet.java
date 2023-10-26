package com.shinhan.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/inputData")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] subjects = request.getParameterValues("subject");
		String gender = request.getParameter("gender");
		
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println(name);
			if(name.equals("subject")) {
				String[] subjects2 = request.getParameterValues(name);
				System.out.println(Arrays.toString(subjects2));
			}else {
				System.out.println(request.getParameter(name));
			}
		}
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("Served at: ")
		.append(request.getContextPath())
		.append("<br>")
		.append(Arrays.toString(subjects))
		.append(gender);
	}

	


}
