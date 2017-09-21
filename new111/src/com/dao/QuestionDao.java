package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entity.Questions;

public class QuestionDao extends BaseDao{
	/**
	 * 添加问题
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int add(Questions qt) throws ClassNotFoundException, SQLException{
		String sql="insert into questions(title,detailDesc,answerCount) values(?,?,?)";
		return super.executeSql(sql, qt.getTitle(),qt.getDetailDesc(),0);
	}
	
	public List<Questions> lookUp(String titles,String modifyTime,int beginIndex, int pageSize) throws ClassNotFoundException, SQLException{
		List<Questions> list=new ArrayList<Questions>();
		try{
			String sql="select * from questions ";
			sql = getSql(titles, modifyTime, sql);
			sql+="limit ?,?";
			super.getConn();
			prsm=conn.prepareStatement(sql);			
			prsm.setInt(1, beginIndex);
			prsm.setInt(2, pageSize);
			rs=prsm.executeQuery();
			Questions qt;
			while(rs.next()){
				qt=new Questions();
				int id=rs.getInt("id");
				String title=rs.getString("title");
				String detailDesc=rs.getString("detailDesc");
				int answerCount=rs.getInt("answerCount");
				Date lastModified=rs.getDate("lastModified");
				qt.setQid(id);
				qt.setTitle(title);
				qt.setDetailDesc(detailDesc);
				qt.setAnswerCount(answerCount);
				qt.setLastModified(lastModified);
				list.add(qt);
			}
		}finally{
			super.closeAll();
		}
		return list;
		
	}

	public String getSql(String titles, String modifyTime, String sql) {
		if(titles!=null && titles.length()>0){
			sql+="where title like '%"+titles+"%' ";
			if(sql.indexOf("where")>0){
				if(modifyTime!=null && modifyTime.length()>0){
					sql+="and lastModified like '%"+modifyTime+"%' ";
				}
			}else{
				if(modifyTime!=null && modifyTime.length()>0){
					sql+="where lastModified like '%"+modifyTime+"%' ";
				}
			}
		}
		return sql;
	}
	
	public Questions getQuestionsById(int id) throws SQLException, ClassNotFoundException{
		super.getConn();
		prsm=conn.prepareStatement("select * from questions where id=?");
		prsm.setInt(1,id);
		rs=prsm.executeQuery();
		Questions qt=null;
		while(rs.next()){
			qt=new Questions();
			qt.setQid(rs.getInt(1));
			qt.setTitle(rs.getString(2));
			qt.setDetailDesc(rs.getString(3));
			qt.setAnswerCount(rs.getInt(4));
			qt.setLastModified(rs.getDate(5));
		}
		super.closeAll();
		return qt;
		
	}

	public int updateCount(int id) throws ClassNotFoundException, SQLException {
			String sql="update questions set answerCount=answerCount+1 where id=?";
			super.executeSql(sql, id);
			return 0;
		}
	
	public int getCount(String titles,String modifyTime) throws ClassNotFoundException, SQLException{
		try{
			String sql="select count(*) from questions ";
			sql = getSql(titles, modifyTime, sql);
			super.getConn();
			prsm=conn.prepareStatement(sql);
			rs=prsm.executeQuery();
			if(rs.next()){
				return rs.getInt(1);				
			}
		}finally{
			super.closeAll();
		}
		return 0;
	}
	}
