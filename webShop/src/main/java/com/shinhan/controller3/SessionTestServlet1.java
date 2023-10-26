package com.shinhan.controller3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.DeptVO;


@WebServlet("/session1")
public class SessionTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); //true:있으면 얻고 없으면 생성
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<br>생성시간: " + new Date(session.getCreationTime()));
		out.println("<br>마지막 접근시간: " + new Date(session.getLastAccessedTime()));
		out.println("<br>아이디: " + session.getId());
		out.println("<br>신규? " + session.isNew());
		
		DeptVO dept = new DeptVO(10,"개발부",100,1700);
		
		session.setMaxInactiveInterval(10);
		session.setAttribute("security1", "옌짱");
		session.setAttribute("security2", "박징짱 바보");
		session.setAttribute("security3", "쟁짱");
		session.setAttribute("security4", dept);
	}

}
