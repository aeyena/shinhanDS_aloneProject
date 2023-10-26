package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.DeptService;
import com.shinhan.model.EmpService;


@WebServlet("/dept/deptDelete.do")
public class DeptDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int did = Integer.parseInt(request.getParameter("deptid"));
		DeptService dservice = new DeptService();
		
		int result = dservice.deleteDept(did);
		request.setAttribute("message", result>0?"삭제성공":"삭제실패");
		
		//JSP에 위임하기(요청은 서블릿이 받고 응답은 JSP가 한다)
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("deptResult.jsp");
		rd.forward(request, response);
	}


}
