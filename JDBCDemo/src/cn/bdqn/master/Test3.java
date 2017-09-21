package cn.bdqn.master;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 实现向修改dog表中记录
 * @author delldell
 *
 */
public class Test3 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement stmt=null;
		
		//1.加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.建立连接
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/epet","epetadmin","0000");
			String sql="update dog set name=?,health=?,love=?,strain=? where id=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,"妮妮");
			stmt.setInt(2,80);
			stmt.setInt(3,90);
			stmt.setString(4,"泰迪");
			stmt.setInt(5,3);
			stmt.executeUpdate();
			System.out.println("狗狗信息更新成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//3.关闭连接
			try {
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
