package com.shinhan.controller2;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.EmpVO;

/**
 * Servlet implementation class TwoServlet
 */
@WebServlet(value="/TwoServlet",loadOnStartup=2)
public class TwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public TwoServlet() {
       System.out.println("TwoServlet 생성자");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ServletContext app = getServletContext();
		
		String company1 = (String)request.getAttribute("company");
		String company2 = (String)session.getAttribute("company");
		String company3 = (String)app.getAttribute("company");
		
		String a = (String)session.getAttribute("myname");
		EmpVO emp = (EmpVO)session.getAttribute("myemp");
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter()
		.append("two")
		.append("<h1>" + a + "</h1>")
		.append("<h1>" + emp + "</h1>")
		.append("<h1>request: " + company1 + "</h1>")
		.append("<h1>session: " + company2 + "</h1>")
		.append("<h1>application: " + company3 + "</h1>")		
		.append(request.getContextPath());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
