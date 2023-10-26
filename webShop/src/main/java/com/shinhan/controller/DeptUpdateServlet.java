package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dto.DeptVO;
import com.shinhan.model.DeptService;


@WebServlet("/dept/deptUpdate.do")
public class DeptUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get방식은 URL에 파라메터값이 encoding되어 전달
		//읽을때 자동으로 decoding된다(한글깨짐없음)
		//post방식은 자동으로 decoding되지 않음 
		request.setCharacterEncoding("utf-8");
		
		String a = request.getParameter("department_id");
		String b = request.getParameter("department_name");
		String c = request.getParameter("manager_id");
		String d = request.getParameter("location_id");
		int deptid = Integer.parseInt(a);
		int mid = Integer.parseInt(c);
		int loc = Integer.parseInt(d);
		DeptVO dept = new DeptVO(deptid,b,mid,loc);
		
		DeptService dservice = new DeptService();
		int result = dservice.updateDept(dept);
		request.setAttribute("message", result>0?"update성공":"update실패");
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("deptResult.jsp");
		rd.forward(request, response);
	}

}
