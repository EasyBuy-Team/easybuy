package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.QuestionDao;
import com.entity.Questions;

public class QuestionsService {
	private int pageSize=4;
	QuestionDao qd=new QuestionDao();
	public int add(Questions qt) throws ClassNotFoundException, SQLException{
		return qd.add(qt);
	}
	
	
	public List<Questions> lookUp(String titles,String modifyTime,int pageNo) throws ClassNotFoundException, SQLException{
		int beginIndex=(pageNo-1)*pageSize;
		return qd.lookUp(titles,modifyTime,beginIndex, pageSize);
	}
	
	public Questions getQuestionsById(int id) throws ClassNotFoundException, SQLException{
		return qd.getQuestionsById(id);
	}


	public int updateCount(int id) throws ClassNotFoundException, SQLException {
		return qd.updateCount(id);
		
	}
	
	public int getPages(String titles,String modifyTime) throws ClassNotFoundException, SQLException{
		int count=qd.getCount(titles,modifyTime);
		return count%pageSize==0?count/pageSize:count/pageSize+1;
	}
}
