import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "vndn9767@@");
			System.out.println("DB���� ����");
			stmt=conn.createStatement();
			printTable(stmt);
//			stmt.executeUpdate("insert into student(id, name, dept) values('1', 'ȫ�浿', '������ǻ�Ͱ���')");
//			printTable(stmt);
			stmt.executeUpdate("update student set id='0203' where name = '����'");
			printTable(stmt);
			stmt.executeUpdate("delete from student where id='1'");
			printTable(stmt);
		}catch(ClassNotFoundException e)
		{
			System.out.println("JDBC����̹� �ε� ����");
		}catch(SQLException e)
		{
			System.out.println("SQL ���� ����");
		}
	}
	
	private static void printTable(Statement stmt)throws SQLException
	{
		ResultSet rs=stmt.executeQuery("select * from student");
		while(rs.next()) {
			System.out.print(rs.getString("name"));
			System.out.print("\t|\t"+rs.getString("id"));
			System.out.println("\t|\t"+rs.getString("dept"));
		}
		System.out.println("--------------------------------------");
	}

}
