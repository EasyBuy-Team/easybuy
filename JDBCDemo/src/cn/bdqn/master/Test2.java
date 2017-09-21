package cn.bdqn.master;

import java.sql.*;

public class Test2 {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement prst=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/epet","epetadmin","0000");
			prst=conn.prepareStatement("insert into dog(name,health,love,strain) values(?,?,?,?)");
			prst.setString(1,"琪琪");
			prst.setInt(2,100);
			prst.setInt(3,100);
			prst.setString(4,"阿拉斯加");
			int result=prst.executeUpdate();
			if(result>0){
				System.out.println("插入成功！");
			}else{
				System.out.println("插入失败");
			}
			
			prst.close();
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
