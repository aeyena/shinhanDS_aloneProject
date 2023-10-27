package com.shinhan.controllerB;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.CrowdFundItem;
import com.shinhan.model.CrowdFundService;


@WebServlet("/businessman/businessmanInsert.do")
public class BusinessmanInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("itemInsert.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String businessmanId = (String)session.getAttribute("businessmanId");
		
		String itemName = request.getParameter("itemName");
		String itemInfo = request.getParameter("itemInfo");
		int targetAmount = Integer.parseInt(request.getParameter("targetAmount"));
		
		CrowdFundService service = new CrowdFundService();
		CrowdFundItem item = new CrowdFundItem(businessmanId,itemName,itemInfo,targetAmount);
		int result = service.registerItem(item);
		
		if (result==0) {
			session.setAttribute("insertResult", "다시 등록해주세요");
			response.sendRedirect("businessmanInsert.do");
			return;
		}
		
		session.setAttribute("insertResult", "");
		response.sendRedirect("businessmanPage.do");
		 
		
	}

}
