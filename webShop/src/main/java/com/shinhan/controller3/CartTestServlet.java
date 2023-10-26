package com.shinhan.controller3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/cart/shopping.do")
public class CartTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
		rd.forward(request, response);
		*/
		request.getRequestDispatcher("cart.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//장바구니담기
		//request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");
		String key = request.getParameter("product");
		Integer count = Integer.parseInt(request.getParameter("count"));
		
		session.setAttribute("productName", key);
		session.setAttribute("productCount", count);
		
		Map<String,Integer> cart = null;
		
		if(obj==null) { //처음장보는것
			cart = new HashMap<>();
			cart.put(key, count);
		}else {
			cart = (Map<String,Integer>)obj;
			Integer originalCnt = cart.get(key);
			if(originalCnt==null) originalCnt = 0;
			cart.put(key, count + originalCnt);
		}
		session.setAttribute("cart", cart);
		response.sendRedirect("shopping.do");
	}

}
