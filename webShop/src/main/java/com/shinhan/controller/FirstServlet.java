package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @WebServlet : 브라우저에서 요청한 주소의미
 * 반드시 /로 시작해야 한다
 * mapping주소설정: 1)@WebServlet 2)web.xml등록
 */
//@WebServlet({ "/FirstServlet", "/first", "/first2" }) 
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public FirstServlet() {
    	System.out.println("FirstServlet 생성자");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet init초기화!");
	}

	public void destroy() {
		System.out.println("FirstServlet 소멸자");
	}

	/*
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet service");
	}
	service 구현되어있지 않으면 => deGet(), doPost()
	*/
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doPost");
	}

}
