package cn.bdqn.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 修改数据
 * @author delldell
 *
 */
public class Revise {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/epet","epetadmin","0000");
			String sql="update master set id=2 where id=5";
			Statement stmt=conn.createStatement();
			int result=stmt.executeUpdate(sql);
			if(result>0){
				System.out.println("更新成功！");
			}else{
				System.out.println("更新失败！");
			}
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
