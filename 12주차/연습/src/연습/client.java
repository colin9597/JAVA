package 연습;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		BufferedReader in=null;
		BufferedWriter out=null;
		Socket socket = null;
		try {
			System.out.println("서버에 접속 요청중...");
			socket=new Socket("localhost", 8600);
			System.out.println("서버에 접속됨");
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			System.out.println(in.readLine());
			while(true) {
				System.out.println(in.readLine());
				System.out.print("-->");
				String text = scanner.nextLine();
				out.write(text);
				System.out.println(in.readLine());
				
				String result=in.readLine();
				
				if(result.equals("win")) {
					System.out.println("클라이언트가 졌다.");
					break;
				}
				if(result.equals("lose")) {
					System.out.println("클라이언트가 이겼다.");
					break;
				}
			}
			System.out.println("연결종료합니다.");
		}catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				scanner.close();
				in.close();
				out.close();
				if(socket!=null) socket.close();
			}catch(IOException e) {
				System.out.println("오류발생");
				e.printStackTrace();
			}
		}
	}

}
