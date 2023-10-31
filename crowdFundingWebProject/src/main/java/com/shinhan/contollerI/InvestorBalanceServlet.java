package com.shinhan.contollerI;

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

@WebServlet("/investor/investorBalance.do")
public class InvestorBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		CrowdFundInvestor investorCheck = (CrowdFundInvestor)session.getAttribute("investor");
		if (investorCheck==null) {
			response.sendRedirect("investorLogin.do");
			return;
		}
		
		String investorId = (String) session.getAttribute("investorId");
		
		CrowdFundService service = new CrowdFundService();
		CrowdFundInvestor investor = service.checkBalance(investorId);
		request.setAttribute("investor", investor); 
		
		RequestDispatcher rd = request.getRequestDispatcher("investorBalance.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String investorId = (String) session.getAttribute("investorId");
		int recharge = Integer.parseInt(request.getParameter("recharge"));
		
		CrowdFundService service = new CrowdFundService();
		int result = service.chargeAmount(investorId, recharge);
		
		if(result==0) {
			session.setAttribute("balanceResult", "다시 충전해주세요");
			response.sendRedirect("investorBalance.do");
		}
		
		session.setAttribute("balanceResult", "");
		response.sendRedirect("investorBalance.do");
		
	}

}
