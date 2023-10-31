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
import com.shinhan.dto.CrowdFundItem;
import com.shinhan.model.CrowdFundService;


@WebServlet("/businessman/businessmanUpdate.do")
public class BusinessmanUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		CrowdFundBusinessman businessman = (CrowdFundBusinessman)session.getAttribute("businessman");
		if (businessman==null) {
			response.sendRedirect("businessmanLogin.do");
			return;
		}
		
		int itemId = Integer.parseInt(request.getParameter("itemid"));
		CrowdFundService service = new CrowdFundService();
		request.setAttribute("item", service.selectByitemId(itemId));
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("businessmanUpdate.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String businessmanId = (String)session.getAttribute("businessmanId");
		
		int itemID = Integer.parseInt(request.getParameter("itemID"));
		String itemName = request.getParameter("itemName");
		String itemInfo = request.getParameter("itemInfo");
		int targetAmount = Integer.parseInt(request.getParameter("targetAmount"));
		int collectedAmount = Integer.parseInt(request.getParameter("collectedAmount"));
		float percentage = Float.parseFloat(request.getParameter("percentage"));
		
		
		CrowdFundItem item = new CrowdFundItem(businessmanId,itemID,itemName,itemInfo,targetAmount,collectedAmount,percentage);
		CrowdFundService service = new CrowdFundService();
		int result = service.updateItem(item);
		
		if (result==0) {
			session.setAttribute("updateResult", "다시 수정해주세요");
			response.sendRedirect("businessmanUpdate.do");
			return;
		}
		
		session.setAttribute("updateResult", "");
		response.sendRedirect("businessmanPage.do");
		
		
		
	}

}
