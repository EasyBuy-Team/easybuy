package cn.bdqn.demo;
/**
 * 添加数据
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Add {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/epet","epetadmin","0000");
			int id=5;
			String name="江沁";
			String pwd="123";
			int money=700;
			String sql="insert into master values("+id+",'"+name+"','"+pwd+"',"+money+")";
			Statement stmt=conn.createStatement();
			int result=stmt.executeUpdate(sql);
			if(result>0){
				System.out.println("插入成功！");
			}else{
				System.out.println("插入失败！");
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
