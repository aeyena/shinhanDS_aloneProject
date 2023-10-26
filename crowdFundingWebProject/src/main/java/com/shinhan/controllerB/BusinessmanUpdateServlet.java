package com.shinhan.controllerB;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.model.CrowdFundService;

/**
 * Servlet implementation class BusinessmanUpdateServlet
 */
@WebServlet("/businessman/businessmanUpdate.do")
public class BusinessmanUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		//String businessmanId = (String)session.getAttribute("businessmanId");
		
		int itemId = Integer.parseInt(request.getParameter("itemid"));
		CrowdFundService service = new CrowdFundService();
		request.setAttribute("item", service.selectByitemId(itemId));
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("businessmanUpdate.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
	}

}
