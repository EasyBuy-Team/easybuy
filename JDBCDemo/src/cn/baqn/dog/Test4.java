package cn.baqn.dog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 实现查询所有狗狗信息
 * @author delldell
 *
 */
public class Test4 {
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
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
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select id,name,health,love,strain from dog");
			System.out.println("狗狗信息列表");
			System.out.println("编号\t昵称\t健康值\t亲密度\t品种");
			while(rs.next()){
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getInt("health")+"\t");
				System.out.print(rs.getInt("love")+"\t");
				System.out.println(rs.getString("strain")+"\t");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//3.关闭连接
			try {
				if(rs!=null){
					rs.close();
				}
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
