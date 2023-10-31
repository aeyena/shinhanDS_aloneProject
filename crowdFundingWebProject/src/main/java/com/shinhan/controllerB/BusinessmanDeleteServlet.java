package com.shinhan.controllerB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.CrowdFundBusinessman;
import com.shinhan.model.CrowdFundService;


@WebServlet("/businessman/businessmanDelete.do")
public class BusinessmanDeleteServlet extends HttpServlet {
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
		
		service.deleteItem(itemId);
		
		response.sendRedirect("businessmanPage.do");
	}

}
