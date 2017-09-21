package cn.bdqn.demo;
/**
 * 删除数据
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Del {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/epet","epetadmin","0000");
			int id=2;
			String sql="delete from master where id="+id+"";
			Statement stmt=conn.createStatement();
			int result=stmt.executeUpdate(sql);
			if(result>0){
				System.out.println("删除成功！");
			}else{
				System.out.println("删除失败！");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
