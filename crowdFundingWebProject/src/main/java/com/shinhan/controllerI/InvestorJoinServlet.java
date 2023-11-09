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


@WebServlet("/investor/investorJoin.do")
public class InvestorJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("investorJoin.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		String investorID = request.getParameter("investorID");
		String investorPW = request.getParameter("investorPW");
		String investorName = request.getParameter("investorName");
		
		CrowdFundService service = new CrowdFundService();
		CrowdFundInvestor investor = new CrowdFundInvestor(investorID,investorPW,investorName);
		int result = service.iJoinMembership(investor);
		
		if (result==0) {
			session.setAttribute("joinResult", "다시 회원가입을 해주세요");
			response.sendRedirect("investorJoin.do");
			return;
		}
		
		session.setAttribute("joinResult", "");
		response.sendRedirect("investorLogin.do"); 
	}
}
