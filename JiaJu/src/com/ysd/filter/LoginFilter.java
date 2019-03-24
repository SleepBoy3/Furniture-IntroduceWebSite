package com.ysd.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		

	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		String name=(String)req.getSession().getAttribute("name");
		if(req.getRequestURI().indexOf("login.jsp")>-1||req.getRequestURI().indexOf("/JiaJu/LoginServlet")>-1||req.getRequestURI().endsWith(".css")||req.getRequestURI().endsWith(".js")){//不过滤登录页面
			chain.doFilter(request, response);
			return;
		} //如果不是登录页面就进行过滤
		if(name!=null){
			/*	chain.doFilter(request, response);*/
			chain.doFilter(request, response);
			return;
			}else{
				res.sendRedirect("login.jsp");
			}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	

	}

	

}
