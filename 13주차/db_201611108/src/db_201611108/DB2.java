package db_201611108;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.mysql.jdbc.PreparedStatement;

public class DB2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn;
		Statement stmt=null;
		PreparedStatement ppstmt =null;
		try {
			Scanner scan = new Scanner(System.in);
			Scanner input = new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "vndn9767@@");
			System.out.println("DB���� ����");
			stmt=conn.createStatement();
			printTable(stmt);
			System.out.println("DB ���� �޴� : 1. �߰�\t"+"2. ����\t"+"3. ����\t"+"4. ������");
			while(true) {
				System.out.println("���� �޴� ��ȣ�� �Է����ּ���(��: 1) : ");
				int cmd = scan.nextInt();
				ppstmt=null;
				if (cmd==1) {
					String insert_SQL="insert into book(id, title, publisher, author) values(?, ?, ?, ?);";
					ppstmt = (PreparedStatement) conn.prepareStatement(insert_SQL);
					System.out.println("�߰� �޴��� �����ϼ̽��ϴ�. �߰� ������ �Է����ּ���.");
					System.out.println("ID : ");
					int _id=scan.nextInt();
					ppstmt.setInt(1,  _id);
					System.out.println("title : ");
					String _title=input.nextLine();
					ppstmt.setString(2, _title);
					System.out.println("publisher : ");
					String _publisher=input.nextLine();
					ppstmt.setString(3, _publisher);
					System.out.println("author : ");
					String _author = input.nextLine();
					ppstmt.setString(4, _author);
					ppstmt.executeUpdate();
				}
				else if(cmd==2) {
					System.out.println("���� �޴��� �����ϼ̽��ϴ�. ������ ���ڵ��� ID ���� �Է����ּ���.");
					System.out.println("ID : ");
					int del_id=scan.nextInt();
					stmt.executeUpdate("delete from book where id="+ del_id);
				}
				else if(cmd==3) {
					System.out.println("���� �޴��� �����ϼ̽��ϴ�. ������ �Ӽ��� �̸��� �Է��ϰ� �������� �Է����ּ���.");
					System.out.println("������ �Ӽ��� �̸� : ");
					String prop=input.nextLine();
					System.out.println("�Ӽ��� ���� �� : ");
					String current=input.nextLine();
					System.out.println("�Ӽ��� ���ο� �� : ");
					String newprop=input.nextLine();
					switch(prop) {
					case "id":
						String iupdate_SQL="update book set id=? where id=?";
						ppstmt = (PreparedStatement) conn.prepareStatement(iupdate_SQL);
						ppstmt.setString(1, newprop);
						ppstmt.setString(2, current);
						ppstmt.executeUpdate();
						break;
					case "title":
						String tupdate_SQL="update book set title=? where title=?";
						ppstmt = (PreparedStatement) conn.prepareStatement(tupdate_SQL);
						ppstmt.setString(1, newprop);
						ppstmt.setString(2, current);
						ppstmt.executeUpdate();
						break;
					case "publisher":
						String pupdate_SQL="update book set publisher=? where publisher=?";
						ppstmt = (PreparedStatement) conn.prepareStatement(pupdate_SQL);
						ppstmt.setString(1, newprop);
						ppstmt.setString(2, current);
						ppstmt.executeUpdate();
						break;
					case "author":
						String aupdate_SQL="update book set author=? where author=?";
						ppstmt = (PreparedStatement) conn.prepareStatement(aupdate_SQL);
						ppstmt.setString(1, newprop);
						ppstmt.setString(2, current);
						ppstmt.executeUpdate();
						break;
					default:
						System.out.println("���� �Ӽ��� �����ϴ�.");
						break;
					}
				}
				else if(cmd==4) {
					System.out.println("������ �޴��� �����ϼ̽��ϴ�. DB�� �����͸� ����ϰ� �����մϴ�.");
					printTable(stmt);
					break;
				}
			}
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
		ResultSet rs=stmt.executeQuery("select * from book");
		while(rs.next()) {
			System.out.print(rs.getString("id"));
			System.out.print("\t|\t"+rs.getString("title"));
			System.out.print("\t|\t"+rs.getString("publisher"));
			System.out.println("\t|\t"+rs.getString("author"));
		}
		System.out.println("---------------------------------------------------------------------------------------------------------");
	}

}
