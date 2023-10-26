package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.EmpVO;
import com.shinhan.model.EmpService;

/**
 * Controller
 */
@WebServlet("/auth/loginCheck.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		int pswd = Integer.parseInt(request.getParameter("pswd"));
		String c = request.getParameter("remember");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		System.out.println(address);
		System.out.println(phone);
		
		EmpService empService = new EmpService();
		EmpVO emp = empService.loginCheck(email, pswd);
		
		//session에 로그인정보 저장하기(있으면얻기,없으면생성)
		HttpSession session = request.getSession();
		
		if(emp==null) {
			session.setAttribute("loginResult", "아이디와 비밀번호 확인요함");
			response.sendRedirect("loginCheck.do");
			return;
		}
		session.setAttribute("loginResult", "");
		//request문서에 "empInfo"이름으로 emp의 값을 저장한다 
		session.setAttribute("empInfo", emp);
		response.sendRedirect("../emp/empList.do");
		
		
		
		
		/*
		//위임하기(요청은 servlet가 받았지만 응답은 JSP에 넘기기)
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("../views/loginResult.jsp");
		rd.forward(request, response);
		//주소창은 변경되지 않고 내용은 forward된 페이지가 보인다
		
		 Servlet가 응답하기...MVC1모델
		 * response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("Served at: ")
		.append(request.getContextPath())
		.append("<p>이메일은 " + email + "</p>")
		.append("<p>이름은 " + emp.getFirst_name() + "</p>");
		*/
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

}
