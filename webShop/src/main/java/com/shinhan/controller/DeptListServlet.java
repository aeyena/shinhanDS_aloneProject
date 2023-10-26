package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.DeptService;


@WebServlet("/dept/deptList.do")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DeptService dService = new DeptService();
		//요청의 영역에 저장하기, key이름은 dlist, 값은 모든부서정보
		request.setAttribute("dlist", dService.selectAll());
		
		//JSP에 위임하기
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("deptList.jsp");
		rd.forward(request, response);
	}

	


}
