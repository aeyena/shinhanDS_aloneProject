package com.shinhan.controllerI;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.CrowdFundFunding;
import com.shinhan.dto.CrowdFundInvestor;
import com.shinhan.dto.CrowdFundItem;
import com.shinhan.model.CrowdFundService;


@WebServlet("/investor/investorMypage.do")
public class InvestorMypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CrowdFundInvestor investor = (CrowdFundInvestor)session.getAttribute("investor");
		if (investor==null) {
			response.sendRedirect("investorLogin.do");
			return;
		}

		String investorId = (String) session.getAttribute("investorId");
		
		CrowdFundService service = new CrowdFundService();
		List<CrowdFundFunding> flist = service.checkFunding(investorId);
		request.setAttribute("flist", flist);
		
		List<CrowdFundItem> ilist = service.selectByIid(investorId);
		request.setAttribute("ilist", ilist);

		RequestDispatcher rd = request.getRequestDispatcher("investorMypage.jsp");
		rd.forward(request, response);
		
	}
}
