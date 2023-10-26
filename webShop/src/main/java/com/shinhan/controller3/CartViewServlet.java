package com.shinhan.controller3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartViewServlet
 */
@WebServlet("/cart/cartview.do")
public class CartViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");
		if(obj == null) {
			response.sendRedirect("shopping.do");
			return;
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Map<String,Integer> cart = (Map<String,Integer>)obj;
		for(String key:cart.keySet()) {
			out.print("<br>이름: " + key + "==>" + cart.get(key));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
