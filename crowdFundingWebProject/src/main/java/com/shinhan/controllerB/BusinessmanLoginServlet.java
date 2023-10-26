package com.shinhan.controllerB;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.CrowdFundBusinessman;
import com.shinhan.model.CrowdFundService;

@WebServlet("/businessman/businessmanLogin.do")
public class BusinessmanLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("businessmanLogin.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String businessmanID = request.getParameter("businessmanID");
		String businessmanPW = request.getParameter("businessmanPW");
		
		CrowdFundService service = new CrowdFundService();
		CrowdFundBusinessman businessman = service.bLogin(businessmanID, businessmanPW);
		
		HttpSession session = request.getSession();
		
		if(businessman==null) {
			session.setAttribute("loginResult", "아이디와 비밀번호 확인요함");
			response.sendRedirect("businessmanLogin.do");
			return;
		}
		
		session.setAttribute("businessman", businessman);
		response.sendRedirect("businessmanPage.do");
		
	}

}
