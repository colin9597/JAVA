import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Game{
	public static int MAX_COUNT=3;
	public static int MAX_INPUT=9;
	private int x=0; 
	private int y=0;
	private boolean val=false;
	private int baseNumber[]= new int[MAX_COUNT];
	private int userNumber[]= new int[MAX_COUNT];
	private int cnt=0;
	
	public Game(){
		randomInt();
		
	}
	public void randomInt() {
		baseNumber[0]=(int)(Math.random()*10);
		while(baseNumber[0]==baseNumber[1]) {
			baseNumber[1]=(int)(Math.random()*10);
		}
		while(baseNumber[0]==baseNumber[2] || baseNumber[1]==baseNumber[2]) {
			baseNumber[2]=(int)(Math.random()*10);
		}
	}
	public void inputUserNubmer(String un) {
		for(int i=0;i<MAX_COUNT; i++) {
			userNumber[i]=Integer.valueOf(un.charAt(i)).intValue();
		}
		countSB(baseNumber, userNumber);
	}
	public void countSB(int a[], int b[]) {
		x=0;
		y=0;
		for(int i=0; i<MAX_COUNT; i++) {
			for(int j=0; j<MAX_COUNT;j++) {
				if(b[i]==a[j])
					if(i==j) x+=1;
					else y+=1;
			}
		}
		cnt++;
		if(x==MAX_COUNT) {
			val=true;
			return;
		}
	}
	public int getX() {return x;}
	public int getY() {return y;}
	public int getCount() {return cnt;}
	public boolean getValue() {return val;}
	
}

public class ServerTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		Socket socket = null;
		BufferedReader in=null;
		BufferedWriter out=null;
		try {
			serverSocket = new ServerSocket(8600);
			System.out.println("연결을 기다리고 있습니다.");
			socket = serverSocket.accept();
			System.out.println("연결됨...");
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String str=" ";
			int cnt2=0;
			boolean val=false;
			char cval;
			int x,y;
			
			Game g = new Game();
			while(true) {
				str=in.readLine();
				g.inputUserNubmer(str);
				//g.countSB(g., b);
				x=g.getX();
				y=g.getY();
				cnt2=g.getCount();
				val=g.getValue();
				if(val) cval='T';
				else cval='F';
				
				System.out.println(str+" : "+x+"S "+y+"B "+cval+" "+cnt2);
				out.write(x+"S "+y+"B "+cval+" "+cnt2+"\n");
				out.flush();
				if(x==3||val==true||cnt2==9) break;
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				if(socket!=null) socket.close();
				if(serverSocket!=null) serverSocket.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
