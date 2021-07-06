package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class server {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		Socket socket = null;
		BufferedReader in=null;
		BufferedWriter out=null;
		try {
			serverSocket = new ServerSocket(8600);
			System.out.println("������ ��ٸ��� �ֽ��ϴ�.");
			socket = serverSocket.accept();
			System.out.println("�����...");
			
			String baseN=null;
			int [] ran=new int[3];
			for (int i=0; i<ran.length; i++) {
				ran[i]=(int)(Math.random()*10);
				for(int j=0; j<i; j++) {
					if(ran[i]==ran[j]) {
						i--;
						break;
					}
				}
			}
			
			baseN=ran[0]+" "+ran[1]+" "+ran[2];
			System.out.println("���� ���� ���� ->"+baseN);
			
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			out.write("�߱� ������ �����մϴ�.");
			int oout=0;
			while(true) {
				int strike=0;
				int ball=0;
				out.write("�� ���� ���Ἥ �Է��ϼ���(ex : 1 2 3)");
				
				String CliNum = in.readLine();
				System.out.println("Ŭ���̾�Ʈ�� �Է��� �� -> "+CliNum);
				StringTokenizer st = new StringTokenizer(CliNum," ");
				
				int [] num= new int[3];
				for(int i=0; i<3; i++) {
					num[i]=Integer.parseInt(st.nextToken());
				}
				
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						if(ran[i]==num[j]) {
							if(i==j) {strike++;}
							else {ball++;}
						}
					}
				}
				
				String str=strike+"S "+ball+"B ("+oout+")��°";
				System.out.
				println(str);
				out.write(str+"");
				
				oout++;
				if(oout>=9) {
					out.write("win");
					System.out.println("�����¸�");
					break;
				}
				else if(strike==3) {
					out.write("lose");
					System.out.println("�����й�");
					break;
				}
				else {
					out.write("");
				}
			}
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				in.close();
				out.close();
				serverSocket.close();
			}catch(IOException e) {
				System.out.println("�����߻�");
				e.printStackTrace();
			}
		}
	}

}
