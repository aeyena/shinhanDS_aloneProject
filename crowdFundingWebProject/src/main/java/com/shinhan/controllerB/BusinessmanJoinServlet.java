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
import com.shinhan.model.CrowdFundService;

@WebServlet("/businessman/businessmanJoin.do")
public class BusinessmanJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("businessmanJoin.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		String businessmanID = request.getParameter("businessmanID");
		String businessmanPW = request.getParameter("businessmanPW");
		String businessmanName = request.getParameter("businessmanName");
		
		CrowdFundService service = new CrowdFundService();
		CrowdFundBusinessman businessman = new CrowdFundBusinessman(businessmanID,businessmanPW,businessmanName);
		int result = service.bJoinMembership(businessman);
		
		if (result==0) {
			session.setAttribute("joinResult", "다시 회원가입을 해주세요");
			response.sendRedirect("businessmanJoin.do");
			return;
		}
		
		session.setAttribute("joinResult", "");
		response.sendRedirect("businessmanLogin.do");
		 
	}

}
