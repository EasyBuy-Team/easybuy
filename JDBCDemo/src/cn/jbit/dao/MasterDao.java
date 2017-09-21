package cn.jbit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.jbit.entity.Master;

public class MasterDao extends BaseDao{
	public int add(int id,String name,String password,int money) throws ClassNotFoundException, SQLException{
			String sql="insert into master(id,name,password,money) values(?,?,?,?)";
			return super.executeSql(sql,id,name,password,money);
	}
	
	public int del(int id) throws ClassNotFoundException, SQLException{
		try {
			String sql="delete from master where id=?";
			return super.executeSql(sql,id);
		} finally{
			super.closeAll();
		}
		
		
	}
	
	public int upDate(int money,int id) throws ClassNotFoundException, SQLException{
		try{
			String sql="update master set money=? where id=?";
			return super.executeSql(sql,money,id);
		}finally{
			super.closeAll();
		}
	}
	
	/**
	 * 查询数据开放发
	 * @return 数据的集合
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Master> look() throws ClassNotFoundException, SQLException{
		List<Master> list=new ArrayList<Master>();
		try{
			super.getConn();
			prsm=conn.prepareStatement("select * from master");
			rs=prsm.executeQuery();
			Master mas;
			while(rs.next()){
				mas=new Master();
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String password=rs.getString(3);
				int money=rs.getInt(4);
				mas.setId(id);
				mas.setName(name);
				mas.setPassword(password);
				mas.setMoney(money);
				list.add(mas);
			}
		}finally{
			super.closeAll();
		}
		return list;
	}
	
	
	
}
