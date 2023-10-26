package com.shinhan.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dto.EmpVO;
import com.shinhan.model.DeptService;
import com.shinhan.model.EmpService;
import com.shinhan.model.JobDAO;
import com.shinhan.util.DateUtil;


//@WebServlet("/emp/empInsert.do")
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DeptService dService = new DeptService();
		JobDAO jDAO = new JobDAO();
		EmpService eservice = new EmpService();
		
		request.setAttribute("dlist", dService.selectAll());
		request.setAttribute("jlist", jDAO.selectAll());
		request.setAttribute("mlist", eservice.selectManagerAll());
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("empInsert_real.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		EmpVO emp = makeEmp(request);
		
		
		EmpService eservice = new EmpService();
		int result = eservice.empInsert(emp);
		request.setAttribute("message", result>0?"insert성공":"insert실패");
		
		//Redirect: 새로운 요청하기
		response.sendRedirect("empList.do");
		
		//forward: 요청받은 서블릿을 수행하고 응답은 JSP가 한다 
		/*
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("empResult.jsp");
		rd.forward(request, response);
		*/
}
	
	private EmpVO makeEmp(HttpServletRequest request) {
		int empid = convertInteger(request.getParameter("employee_id"));
		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone_number");
		Date hdate = DateUtil.convertDate(request.getParameter("hire_date"));
		String jobid = request.getParameter("job_id");
		int salary = convertInteger(request.getParameter("salary"));
		double comm = convertDouble(request.getParameter("commission_pct"));
		int mid = convertInteger(request.getParameter("manager_id"));
		int deptid = convertInteger(request.getParameter("department_id"));
		
		EmpVO emp = new EmpVO();
		emp.setCommission_pct(comm);
		emp.setDepartment_id(deptid);
		emp.setEmail(email);
		emp.setEmployee_id(empid);
		emp.setFirst_name(fname);
		emp.setHire_date(hdate);
		emp.setJob_id(jobid);
		emp.setLast_name(lname);
		emp.setManager_id(mid);
		emp.setPhone_number(phone);
		emp.setSalary(salary);
		return emp;
	}

	private int convertInteger(String str) {
		if(str==null) return 0;
		return Integer.parseInt(str);
	}
	

	private Double convertDouble(String str) {
		if(str==null) return 0.0;
		return Double.parseDouble(str);
	}
}

	
