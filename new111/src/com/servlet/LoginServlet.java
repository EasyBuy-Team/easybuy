package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;
import com.service.LoginService;
import com.web.OnLineUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户名和密码
		int result=0;
		String name=request.getParameter("uname");
		String password=request.getParameter("password");
		LoginService ls=new LoginService();
		try {
			result=ls.lookUp(name,password);
			if(result>0){
				HttpSession session=request.getSession();
				User user=new User();
				user.setUname(name);
				user.setPassword(password);
				session.setAttribute("user",user);
				OnLineUser onLineUser=new OnLineUser();
				onLineUser.setUser(user);
				request.getSession().setAttribute("users",onLineUser);
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}else{
				request.setAttribute("mess","用户名或密码错误！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
