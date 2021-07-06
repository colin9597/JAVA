import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class CalcServer {
	public static String calc(String exp)
	{
		StringTokenizer st = new StringTokenizer(exp, " ");
		if(st.countTokens()!=3) return "error";
		String res="";
		int op1=Integer.parseInt(st.nextToken());
		String opcode=st.nextToken();
		int op2=Integer.parseInt(st.nextToken());
		switch(opcode)
		{
		case "+" : res=Integer.toString(op1+op2);break;
		case "-" : res=Integer.toString(op1-op2);break;
		case "*" : res=Integer.toString(op1*op2);break;
		default: res="error";
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in=null;
		BufferedWriter out=null;
		ServerSocket listener=null;
		Socket socket = null;
		try{
			listener=new ServerSocket(9999);
			System.out.println("연결을 기다리고 있습니다.");
			socket=listener.accept();
			System.out.println("연결됨..");
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				String M=in.readLine();
				if(M.equalsIgnoreCase("bye"))
				{
					System.out.println("클라이언트 연결 종료");
					break;
				}
				System.out.println(M);
				String res=calc(M);
				out.write(res+"\n");
				out.flush();
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally
		{
			try {
				if(socket!=null) socket.close();
				if(listener!=null) listener.close();
			}catch(IOException e) {
				System.out.println("채팅오류");
			}
		}
	}

}
