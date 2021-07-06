import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class BaseballGameClient {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("서버에 연결중입니다.....");
			Socket so = new Socket("localhost", 7777); //클라이언트 소켓 생성 및 서버에 접속
			
			InputStream in = so.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			OutputStream out = so.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);

			System.out.println(dis.readUTF()); //"야구 게임을 시작합니다" 출력(서버에서 처음에 전송한 내용)

			while (true) {
				System.out.println(dis.readUTF());	//"세 수를 띄어 써서 입력해주세요(ex: 1 2 3)" 출력(서버에서 전송)		
				System.out.print("-->");
				String text = scanner.nextLine(); 	// 3개의 숫자를 입력받음
				dos.writeUTF(text);					// 입력받은 데이터를 서버에 전송
				System.out.println(dis.readUTF());	// 결과 수신(ex: 1strike 2ball (1)번째)			
				String sel =dis.readUTF();			// 서버의 승패 결과 수신("lose" or "win")

				if(sel.equals("win")) {
					System.out.println("클라이언트가 졌다.");
					break;
				}			
				if(sel.equals("lose")) {
					System.out.println("클라이언트가 이겼다.");
					break;
				}
			}
			System.out.println("연결종료합니다.");
			dis.close();
			dos.close();
			so.close();
			scanner.close();
		} catch (Exception e) {
		}
	}
}