package cn.baqn.dog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用纯java方式连接和关闭数据库
 * @author delldell
 *
 */
public class Test2 {
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		String name="小米";
		int health=100;
		int love=60;
		String strain="哈士奇";
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
			//insert into dog(name,health,love,strain)values('
			//欧欧',
			//100,
			//60,'
			//酷酷的雪纳瑞');
			//想dog表中插入一条数据
			StringBuffer sql =new StringBuffer("insert into dog(name,health,love,strain)values('");
			sql.append(name+"',");
			sql.append(health+",");
			sql.append(love+",'");
			sql.append(strain+"');");
			stmt.execute(sql.toString());
			System.out.println("插入狗狗信息成功！");
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
