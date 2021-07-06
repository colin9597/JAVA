import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in=null;
		BufferedWriter out=null;
		Socket socket = null;
		Scanner scanner=new Scanner(System.in);
		try{
			socket=new Socket("localhost", 9999);
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				System.out.print("계산식>>");
				String M=scanner.nextLine();
				if(M.equalsIgnoreCase("bye"))
				{
					out.write(M+"\n");
					out.flush();
					break;
				}
				
				out.write(M+"\n");
				out.flush();
				String resM=in.readLine();
				System.out.println("계산결과 : "+resM);
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally
		{
			try {
				if(socket!=null) socket.close();
			}catch(IOException e) {
				System.out.println("채팅오류");
			}
		}
	}

}
