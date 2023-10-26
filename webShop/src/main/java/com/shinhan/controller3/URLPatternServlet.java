package com.shinhan.controller3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.RequiresStatement;


@WebServlet("/aa/*")
public class URLPatternServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ContextPath: " + request.getContextPath());
		System.out.println("RequestURL: " + request.getRequestURL());
		System.out.println("RequestURI: " + request.getRequestURI());
		System.out.println("RemotePort: " + request.getRemotePort());
		System.out.println("RemoteAddr: " + request.getRemoteAddr());
		System.out.println("Method: " + request.getMethod());
		System.out.println("ServletPath: " + request.getServletPath());
		System.out.println("QueryString: " + request.getQueryString());
		
		//MIME Type: 웹상에서 주고받은 타입은 이미 정해져있다
		//text/html, text/json
		response.setContentType("text/html;charset=utf-8");
		
		response.getWriter()
		.append(request.getContextPath());	
		
	}

	

}
