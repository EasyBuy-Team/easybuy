package cn.bdqn.master;

import java.sql.*;

public class Test {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		/*String name="程南亚";
		String pwd="123";
		int money=100;*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/epet","epetadmin","0000");
			stmt=conn.createStatement();
			/*//insert into master (name,password,money) values ('
			//刘春蕾','
			//123',
			//200);
			StringBuffer sql=new StringBuffer("insert into master (name,password,money) values ('");
			sql.append(name+"','");
			sql.append(pwd+"',");
			sql.append(money+");");
			stmt.execute(sql.toString());
			System.out.println("插入主人信息成功！");*/
			
			rs=stmt.executeQuery("select id,name,password,money from master");
			System.out.println("\t\t主人信息列表");
			System.out.println("编号\t姓名\t密码\t元宝数");
			while(rs.next()){
				System.out.print(rs.getInt("id")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getString("password")+"\t");
				System.out.println(rs.getInt("money")+"\t");
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
