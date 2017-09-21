package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.AnswersDao;
import com.entity.Answer;

public class AnswersService {
	AnswersDao ad=new AnswersDao();
	public List<Answer> getListById(int qid) throws ClassNotFoundException, SQLException{
		return ad.getListById(qid);
	}
	public int add(Answer ans) throws ClassNotFoundException, SQLException {
		return ad.add(ans);
	}
}
