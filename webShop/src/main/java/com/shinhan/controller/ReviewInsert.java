package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/html/reviewInsert")
public class ReviewInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReviewInsert() {
		System.out.println("ReviewInsert 생성자");
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("ReviewInsert init");
	}

	public void destroy() {
		System.out.println("ReviewInsert 소멸");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// service 구현되어있으면 service만 수행
		// service 구현되어있지 않으면 doGet(), doPost()

		System.out.println("요청방식:" + request.getMethod());
		System.out.println("getRequestURI:" + request.getRequestURI());
		System.out.println("getRemoteAddr:" + request.getRemoteAddr());
		System.out.println("getContextPath:" + request.getContextPath());
		System.out.println("getRealPath:" + request.getRealPath("."));

		System.out.println("ReviewInsert get");
		String addr = request.getRemoteAddr();
		System.out.println("요청한 IP:" + addr);

		// http://localhost:9999/webShop/html/reviewInsert
		// ?id=d&pwd=d&hobby=%EC%9E%A0%EC%9E%90%EA%B8%B0&age=10%EB%8C%80&massage=d
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String[] hobby = request.getParameterValues("hobby");
		String age = request.getParameter("age");
		String massage = request.getParameter("massage");

		System.out.println(id + ":" + pwd);
		System.out.println(Arrays.toString(hobby));
		System.out.println(age + ":" + massage);

		request.setAttribute("resultMessage", "입력성공");

		// Servlet이 JSP에 위임하기
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("../views/review.jsp");
		rd.forward(request, response);

		/*
		 * HTML로 전송 시: text/html 
		 * 일반 텍스트로 전송 시: text/plain 
		 * XML 데이터로 전송 시: application/xml
		 */

		/*
		 * response.setContentType("text/html;charset=utf-8"); PrintWriter out =
		 * response.getWriter(); out.write("<p>id==>" + id + "</p>");
		 * out.write("<p>pwd==>" + pwd + "</p>"); out.write("<p>hobby==>" +
		 * Arrays.toString(hobby) + "</p>"); out.write("<p>age==>" + age + "</p>");
		 * out.write("<p>massage==>" + massage + "</p>");
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ReviewInsert post");
	}

}
