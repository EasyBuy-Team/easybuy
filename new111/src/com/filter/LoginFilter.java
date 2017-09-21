package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//jiangServletRequest强制转换HttpServletRequest类型
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		Object obj=session.getAttribute("user");
		User user=null;
		if(obj!=null ){
			user=(User)obj;
			chain.doFilter(request, response);
		}else{
			String url=req.getRequestURI();
			if(url.indexOf("login.jsp")>=0 || url.indexOf("loginServlet.do")>=0){
				chain.doFilter(request, response);
			}else{
				HttpServletResponse resp=(HttpServletResponse)response;
				resp.sendRedirect("login.jsp");
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
