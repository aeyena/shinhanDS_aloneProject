package com.shinhan.controllerI;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.CrowdFundInvestor;
import com.shinhan.model.CrowdFundService;


@WebServlet("/investor/investorLogin.do")
public class InvestorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("investorLogin.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String investorID = request.getParameter("investorID");
		String investorPW = request.getParameter("investorPW");
		
		CrowdFundService service = new CrowdFundService();
		CrowdFundInvestor investor = service.iLogin(investorID, investorPW);
		
		HttpSession session = request.getSession();
		
		if(investor==null) {
			session.setAttribute("loginResult", "아이디와 비밀번호 확인요함");
			response.sendRedirect("investorLogin.do");
			return;
		}
		
		session.setAttribute("investor", investor);
		String investorId = investor.getInvestorID().trim();
		session.setAttribute("investorId", investorId);
		response.sendRedirect("investorPage.do");
	}

}
