package ����;

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
			System.out.println("������ ���� ��û��...");
			socket=new Socket("localhost", 8600);
			System.out.println("������ ���ӵ�");
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
					System.out.println("Ŭ���̾�Ʈ�� ����.");
					break;
				}
				if(result.equals("lose")) {
					System.out.println("Ŭ���̾�Ʈ�� �̰��.");
					break;
				}
			}
			System.out.println("���������մϴ�.");
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
				System.out.println("�����߻�");
				e.printStackTrace();
			}
		}
	}

}
