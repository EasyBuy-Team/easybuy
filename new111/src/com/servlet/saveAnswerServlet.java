package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Answer;
import com.service.AnswersService;
import com.service.QuestionsService;

/**
 * Servlet implementation class saveAnswerServlet
 */
@WebServlet("/saveAnswer.do")
public class saveAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AnswersService as=new AnswersService();
		QuestionsService qs=new QuestionsService();
		int id=0;
		String str=request.getParameter("id");
		if(str!=null && str.trim().length()>0){
			id=Integer.parseInt(str);
		}
		String ansContent=request.getParameter("ansContent");
		Answer ans=new Answer();
		ans.setQid(id);
		ans.setAnsContent(ansContent);
		int count;
		try {
			count = as.add(ans);
			if(count>0){
				int result=qs.updateCount(id);
				if(result>0){
					response.sendRedirect("updateAnswers.do?id="+id);
				}
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
