import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class BaseballGameServer {
	public static void main(String[] args) {
		ServerSocket listener = null;
		try {
			listener = new ServerSocket(7777);
			System.out.println("클라이언트의 접속을 기다립니다 . . . . . .");
			Socket socket = listener.accept();
			String numb=null;
			int [] ran=new int [3];
			for(int i=0; i<ran.length; i++) { 	// 각각 다른 숫자를 ran 배열안에 넣는다.
				ran[i]=(int)(Math.random()*10); // 범위는 0~9사이의 정수
				for(int j=0; j<i; j++) {		// 중복검사
					if(ran[i]==ran[j]) {
						i--;
						break;
					}
				}
			}

			numb=ran[0]+" "+ran[1]+" "+ran[2]; 	// 띄어쓰기로 구분하기 위해 따로 변수에 넣는다.
			System.out.println("서버 랜덤 숫자 ->"+numb);

			InputStream in = socket.getInputStream(); 			//소켓으로부터 데이터를 전송할 입출력 스트림 생성
			DataInputStream dis = new DataInputStream(in);
			OutputStream out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);

			dos.writeUTF("야구 게임을 시작합니다."); 	// 클라이언트로 데이터 전송

			int oout=0; //총 게임 횟수를 제한하기 위한 변수
			while (true) {
				int strike=0;
				int ball=0;
				dos.writeUTF("세 수를 띄어 써서 입력해주세요(ex: 1 2 3)");

				String a = dis.readUTF(); // 클라이언트가 입력한 데이터 수신
				System.out.println("클라이언트가 입력한 수 -> " + a);

				StringTokenizer st = new StringTokenizer(a," "); // 입력받은 데이터를 띄어쓰기 기준으로 구분

				int [] nnum=new int [3]; // 클라이언트가 입력한 수를 정수형으로 저장
				for(int i=0; i<3;i++) {
					nnum[i]=Integer.parseInt(st.nextToken());
				}

				for(int i=0; i<3; i++) { // 규칙에 맞게 strike와 ball 증가
					for(int j=0; j<3; j++) {
						if(ran[i]==nnum[j]) {
							if(i==j) {
								strike++;
							}
							else {
								ball++;
							}
						}
					}
				}

				String str=strike+"스트라이크 "+ball+"볼   ("+oout+")번째";
				System.out.println(str);
				dos.writeUTF(str); //결과를 클라이언트로 전송

				oout++; //규칙에 맞게 3strike이면 서버패, 클라이언트 승/ 횟수 9회 초과시 서버승, 클라이언트 패
				if(strike==3) {
					System.out.println("서버패배");
					dos.writeUTF("lose");
					break;
				}
				else if(oout>=10) {
					dos.writeUTF("win");
					System.out.println("서버승리");
					break;
				}
				else {
					dos.writeUTF("");
				}
			}
			dos.close();
			dis.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("오류발생");
			e.printStackTrace();
		}
	}
}