package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Questions;
import com.google.gson.Gson;
import com.service.QuestionsService;

/**
 * Servlet implementation class GsonServlet
 */
@WebServlet("/gson.do")
public class GsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//生成QuestionService对象
		QuestionsService qs=new QuestionsService();
		List<Questions> list=null;
		//调用查询所有的方法
		try {
			list=qs.show(page);
			//生成Gson对象
			Gson gson=new Gson();
			//调用Gson对象的toJson()方法
			String str=gson.toJson(list);
			//设置文本类型和字符编码
			response.setContentType("text/html; charset=UTF-8");
			//生成文件流对象
			PrintWriter writer=response.getWriter();
			//写如
			writer.write(str);
			//刷新文件流
			writer.flush();
			//关闭文件流
			writer.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
