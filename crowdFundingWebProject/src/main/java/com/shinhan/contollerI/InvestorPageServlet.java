package com.shinhan.contollerI;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.CrowdFundInvestor;
import com.shinhan.dto.CrowdFundItem;
import com.shinhan.model.CrowdFundService;


@WebServlet("/investor/investorPage.do")
public class InvestorPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CrowdFundInvestor investor = (CrowdFundInvestor)session.getAttribute("investor");
		if (investor==null) {
			response.sendRedirect("investorLogin.do");
			return;
		}
			
		CrowdFundService service = new CrowdFundService();		
		List<CrowdFundItem> ilist = service.selectAll();
		request.setAttribute("ilist", ilist);
		
		RequestDispatcher rd = request.getRequestDispatcher("investorPage.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String search = request.getParameter("search");
		CrowdFundService service = new CrowdFundService();
		List<CrowdFundItem> ilist = service.selectBySearch(search);
		request.setAttribute("ilist", ilist);
		
		RequestDispatcher rd = request.getRequestDispatcher("investorPage.jsp");
		rd.forward(request, response);
	}

}
