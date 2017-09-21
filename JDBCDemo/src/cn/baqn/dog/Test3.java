package cn.baqn.dog;
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
		int result=0;
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
			stmt=conn.prepareStatement("update dog set status=0 where id=?");
			stmt.setInt(1,1);
			if(result>0){
				System.out.println("狗狗信息更新成功！");
			}else{
				System.out.println("狗狗信息更新失败！");
			}
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
