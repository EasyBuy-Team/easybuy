package com.dao;

import java.sql.SQLException;

public class LoginDao extends BaseDao{
	public int lookUp(String name, String password) throws SQLException, ClassNotFoundException {
		super.getConn();
		String sql="select count(*) from users where uname=? and password=?";
		prsm=conn.prepareStatement(sql);
		prsm.setString(1,name);
		prsm.setString(2,password);
		rs=prsm.executeQuery();
		if(rs.next()){
			int result=rs.getInt(1);
			return result;
		}
		return 0;
	}
}
