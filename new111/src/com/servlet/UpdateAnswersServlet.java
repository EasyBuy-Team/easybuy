package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Answer;
import com.entity.Questions;
import com.service.AnswersService;
import com.service.QuestionsService;

/**
 * Servlet implementation class UpdateAnswersServlet
 */
@WebServlet("/updateAnswers.do")
public class UpdateAnswersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//调用两个service方法
		int id=0;
		QuestionsService qs=new QuestionsService();
		AnswersService as=new AnswersService();
		String str=request.getParameter("id");
		if(str!=null && str.trim().length()>0){
			id=Integer.parseInt(str);
		}
		try {
			Questions questions=qs.getQuestionsById(id);
			List<Answer> list=as.getListById(id);
			request.setAttribute("questions",questions);
			request.setAttribute("anList",list);
			request.getRequestDispatcher("details.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
