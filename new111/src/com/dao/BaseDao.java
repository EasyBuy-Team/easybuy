package com.dao;

import java.sql.*;

public class BaseDao {
	protected Connection conn;
	protected Statement stmt;
	protected ResultSet rs;
	protected PreparedStatement prsm;
	
	//封装 加载驱动、建立连接
	public void getConn() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/showquestion","root","mysql");
	}
	
	public int executeSql(String sql,Object... obj) throws ClassNotFoundException, SQLException{
		try {
			getConn();
			prsm=conn.prepareStatement(sql);
			for(int i=0;i<obj.length;i++){
				prsm.setObject(i+1,obj[i]);
			}
				int result=prsm.executeUpdate();
				return result;
		}finally{
			closeAll();
		}
	}
	
	public void closeAll(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(prsm!=null){
			try {
				prsm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
