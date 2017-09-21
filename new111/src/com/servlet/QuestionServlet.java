package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Questions;
import com.service.QuestionsService;

public class QuestionServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收问题，问题描述
		request.setCharacterEncoding("utf-8");
		String question=request.getParameter("questions");
		String qdetail=request.getParameter("questionDesc");
		//创建一个Question对象
		Questions qs=new Questions();
		qs.setTitle(question);
		qs.setDetailDesc(qdetail);
		//将qs保存到数据库,调用业务逻辑层
		QuestionsService qss=new QuestionsService();
		try {
			int count=qss.add(qs);
			if(count>0){
				//成功后返回首页
				response.sendRedirect("index.jsp");
			}
			else{
				//跳转到错误页面
				response.sendRedirect("error.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
