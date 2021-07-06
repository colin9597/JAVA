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
			System.out.println("DB연결 성공");
			stmt=conn.createStatement();
			printTable(stmt);
			System.out.println("DB 관리 메뉴 : 1. 추가\t"+"2. 삭제\t"+"3. 수정\t"+"4. 끝내기");
			while(true) {
				System.out.println("관리 메뉴 번호를 입력해주세요(예: 1) : ");
				int cmd = scan.nextInt();
				ppstmt=null;
				if (cmd==1) {
					String insert_SQL="insert into book(id, title, publisher, author) values(?, ?, ?, ?);";
					ppstmt = (PreparedStatement) conn.prepareStatement(insert_SQL);
					System.out.println("추가 메뉴를 선택하셨습니다. 추가 정보를 입력해주세요.");
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
					System.out.println("삭제 메뉴를 선택하셨습니다. 삭제할 레코드의 ID 값을 입력해주세요.");
					System.out.println("ID : ");
					int del_id=scan.nextInt();
					stmt.executeUpdate("delete from book where id="+ del_id);
				}
				else if(cmd==3) {
					System.out.println("수정 메뉴를 선택하셨습니다. 수정할 속성의 이름을 입력하고 수정값을 입력해주세요.");
					System.out.println("수정할 속성의 이름 : ");
					String prop=input.nextLine();
					System.out.println("속성의 현재 값 : ");
					String current=input.nextLine();
					System.out.println("속성의 새로운 값 : ");
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
						System.out.println("위의 속성은 없습니다.");
						break;
					}
				}
				else if(cmd==4) {
					System.out.println("끝내기 메뉴를 선택하셨습니다. DB의 데이터를 출력하고 종료합니다.");
					printTable(stmt);
					break;
				}
			}
		}catch(ClassNotFoundException e)
		{
			System.out.println("JDBC드라이버 로드 실패");
		}catch(SQLException e)
		{
			System.out.println("SQL 실행 에러");
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
