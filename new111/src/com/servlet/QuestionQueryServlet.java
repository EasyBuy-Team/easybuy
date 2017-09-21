package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Questions;
import com.service.QuestionsService;

public class QuestionQueryServlet extends HttpServlet{
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		QuestionsService qs=new QuestionsService();
		int pageNo=1;
		String str=request.getParameter("pageNo");
		String titles=request.getParameter("title");
		String modifyTime=request.getParameter("modifyTime");
		try {
			if(str!=null && str.length()>0){
				pageNo=Integer.parseInt(str);
			}
			int pages=qs.getPages(titles,modifyTime);
			request.setAttribute("pages",pages);
			List<Questions> list=qs.lookUp(titles,modifyTime,pageNo);
			request.setAttribute("list",list);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
