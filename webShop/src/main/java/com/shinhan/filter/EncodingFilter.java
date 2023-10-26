package com.shinhan.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * @WebFilter("*.do") : 언제 이 필터를 수행할 것인지에 대한 URL pattern
 */
@WebFilter("*.do")
public class EncodingFilter extends HttpFilter implements Filter {
    
    public EncodingFilter() {
        System.out.println("EncodingFilter 생성");
    }

	public void destroy() {
		System.out.println("EncodingFilter 소멸");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
