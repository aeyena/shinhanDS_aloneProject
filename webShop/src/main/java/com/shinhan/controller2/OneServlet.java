package com.shinhan.controller2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.EmpVO;

/**
 * Servlet implementation class OneServlet
 */
@WebServlet(value="/OneServlet",loadOnStartup=1)
public class OneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OneServlet() {
        System.out.println("OneServlet 생성자");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//session은 하나의 Browser
		HttpSession session = request.getSession();
		
		//context는 웹application마다 한개 
		ServletContext app = getServletContext();
		
		EmpVO emp = new EmpVO();
		emp.setFirst_name("kim");
		
		String myname = request.getParameter("myname");
		
		
		request.setAttribute("company", "신한request");
		session.setAttribute("company", "신한session");
		app.setAttribute("company", "신한ServletContext" + myname);
		
		
		session.setAttribute("myname",myname);
		session.setAttribute("myemp",emp);
		
		//application에 저장된 파라메터 읽기
		String db_id = app.getInitParameter("dbid");
		String db_pw = app.getInitParameter("dbpass");
		System.out.println(db_id);
		System.out.println(db_pw);
		
		//response.sendRedirect("TwoServlet");
		
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("TwoServlet");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
