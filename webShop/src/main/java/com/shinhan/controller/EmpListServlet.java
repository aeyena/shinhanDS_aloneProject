package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.EmpVO;
import com.shinhan.model.EmpService;


//@WebServlet("/emp/empList.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		EmpService service = new EmpService();
		List<EmpVO> emplist = service.selectAll();
		request.setAttribute("emplist", emplist);
		
		RequestDispatcher rd = request.getRequestDispatcher("empList.jsp");
		rd.forward(request, response);
		
	}


}
