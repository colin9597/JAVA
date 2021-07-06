package jongkyu.tcp.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("���� IP�Է� : ");
			// String serverIP = sc.next();
			String serverIp = "localhost";
			System.out.println("������ �������Դϴ�....." + serverIp);
			// ���ϻ���
			Socket so = new Socket(serverIp, 7777);
			System.out.println("Ŭ���̾�Ʈ ������ ���� �߽��ϴ�.");
			// �������� �޼��� �޾ƾ� �Ѵ�.
			InputStream in = so.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			OutputStream out = so.getOutputStream();// ������� ������ �ƿ�ǲ��Ʈ���ְڴ�.
			DataOutputStream dos = new DataOutputStream(out);

			System.out.println(dis.readUTF());
			//System.out.println("���Թ����� " + dis.readUTF());

			while (true) {
				System.out.println(dis.readUTF());				
				//System.out.print("���� �Է��Ѱ� : ");
				System.out.print("-->");
				String text = sc.nextLine();
				dos.writeUTF(text);//����� �����°�			
				System.out.println(dis.readUTF());				

				String sel =dis.readUTF();//��Ʈ����ũ �� �޴°�			

				if(sel.equals("win")) {
					System.out.println("Ŭ���̾�Ʈ�� ����.");
					break;
				}			
				if(sel.equals("lose")) {
					System.out.println("Ŭ���̾�Ʈ�� �̰��.");
					break;
				}
			}
			System.out.println("���������մϴ�.");
			dis.close();
			dos.close();
			so.close();
		} catch (Exception e) {
		}
	}
}