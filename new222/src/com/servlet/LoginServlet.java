package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//声明用户对象
		User user=null;
		//获取session对象
		HttpSession session=request.getSession();
		String errorMsg=null;
		//设置请求编码为utf-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取用户名密码
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		//判断用户名和密码是否为空
		if(userName==null || password==null || (userName.trim().equals("") || password.trim().equals(""))){
			errorMsg="用户名或者密码不能为空";
			request.setAttribute("errorMsg",errorMsg);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else if(userName.equals("admin") && password.equals("123456")){
			user=new User();
			user.setUserName(userName);
			user.setPassword(password);
			//admin :管理员  p:人事 t：程序员   f：财务
			user.setRole("f");
			session.setAttribute("user",user);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else{
			errorMsg="用户名或者密码不正确";
			request.setAttribute("errorMsg",errorMsg);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
