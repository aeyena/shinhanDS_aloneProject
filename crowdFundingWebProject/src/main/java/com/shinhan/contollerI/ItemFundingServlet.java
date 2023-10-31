package com.shinhan.contollerI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.CrowdFundFunding;
import com.shinhan.dto.CrowdFundInvestor;
import com.shinhan.model.CrowdFundService;

@WebServlet("/investor/itemFunding.do")
public class ItemFundingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CrowdFundInvestor investor = (CrowdFundInvestor)session.getAttribute("investor");
		if (investor==null) {
			response.sendRedirect("investorLogin.do");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String investorId = (String) session.getAttribute("investorId");
		
		int itemID = Integer.parseInt(request.getParameter("itemID"));
		int investmentAmount = Integer.parseInt(request.getParameter("investmentAmount"));
		
		CrowdFundFunding funding = new CrowdFundFunding(investorId,itemID,investmentAmount);
		CrowdFundService service = new CrowdFundService();
		int result = service.insertFunding(funding);
		
		if(result==0) {
			session.setAttribute("fundingResult", "다시 펀딩해주세요");
			response.sendRedirect("investorFunding.do");
		}
		
		session.setAttribute("fundingResult", "");
		response.sendRedirect("investorFunding.do");
		
	}

}
