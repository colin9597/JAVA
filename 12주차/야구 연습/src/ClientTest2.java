import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in=null;
		BufferedWriter out=null;
		Socket socket = null;
		Scanner scanner=new Scanner(System.in);
		int cnt=0;
		try {
			System.out.println("������ ���� ��û��...");
			socket=new Socket("localhost", 8600);
			System.out.println("������ ���ӵ�");
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String str="", str1="";
			System.out.println("�߱� ������ �����մϴ�.");
			while(true) {
				System.out.println("����3���Է�>>");
				str=scanner.nextLine();
				if(str.length()!=3) {
					System.out.println("�ٽ� �Է��ϼ���.\n����3���Է�>>");
					str=scanner.nextLine();
				}
				cnt++;
				out.write(str+"\n");
				out.flush();
				str1=in.readLine();
				System.out.println("���>>"+str1);
				
				if(str1.charAt(0)=='3'||str1.charAt(6)=='T' || cnt==9) break;
			}
			System.out.println("����(Ŭ���̾�Ʈ)");
		}catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				scanner.close();
				if(socket!=null) socket.close();
			}catch(IOException e) {
				System.out.println("�����߻�");
				e.printStackTrace();
			}
		}
	}

}
