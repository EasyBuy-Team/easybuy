package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Answer;

public class AnswersDao extends BaseDao{
	public List<Answer> getListById(int qid) throws SQLException, ClassNotFoundException{
		List<Answer> list=new ArrayList<Answer>();
		super.getConn();
		prsm=conn.prepareStatement("select * from Answers where qid=?");
		prsm.setInt(1,qid);
		rs=prsm.executeQuery();
		Answer an=null;
		while(rs.next()){
			an=new Answer();
			an.setId(rs.getInt(1));
			an.setAnsContent(rs.getString(2));
			an.setAnsDate(rs.getDate(3));
			an.setQid(rs.getInt(4));
			list.add(an);
		}
		return list;
	}

	public int add(Answer ans) throws ClassNotFoundException, SQLException {
		String sql="insert into answers(ansContent,qid) value(?,?);";
		return super.executeSql(sql, ans.getAnsContent(),ans.getQid());
	}
}
