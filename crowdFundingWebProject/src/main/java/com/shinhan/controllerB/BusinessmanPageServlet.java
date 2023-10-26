package com.shinhan.controllerB;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.CrowdFundBusinessman;
import com.shinhan.dto.CrowdFundItem;
import com.shinhan.model.CrowdFundService;

/**
 * Servlet implementation class BusinessmanPageServlet
 */
@WebServlet("/businessman/businessmanPage.do")
public class BusinessmanPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		CrowdFundBusinessman businessman = (CrowdFundBusinessman)session.getAttribute("businessman");
		if (businessman==null) {
			response.sendRedirect("businessmanLogin.do");
			return;
		}
		
		String businessmanId = businessman.getBusinessmanID().trim();
		
		session.setAttribute("businessmanId", businessmanId);		
		CrowdFundService service = new CrowdFundService();		
		List<CrowdFundItem> ilist = service.selectByBid(businessmanId);	
		request.setAttribute("ilist", ilist);
		
		RequestDispatcher rd = request.getRequestDispatcher("businessmanPage.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
