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
			System.out.println("Ŭ���̾�Ʈ�� ������ ��ٸ��ϴ� . . . . . .");
			Socket socket = listener.accept();
			String numb=null;
			int [] ran=new int [3];
			for(int i=0; i<ran.length; i++) { 	// ���� �ٸ� ���ڸ� ran �迭�ȿ� �ִ´�.
				ran[i]=(int)(Math.random()*10); // ������ 0~9������ ����
				for(int j=0; j<i; j++) {		// �ߺ��˻�
					if(ran[i]==ran[j]) {
						i--;
						break;
					}
				}
			}

			numb=ran[0]+" "+ran[1]+" "+ran[2]; 	// ����� �����ϱ� ���� ���� ������ �ִ´�.
			System.out.println("���� ���� ���� ->"+numb);

			InputStream in = socket.getInputStream(); 			//�������κ��� �����͸� ������ ����� ��Ʈ�� ����
			DataInputStream dis = new DataInputStream(in);
			OutputStream out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);

			dos.writeUTF("�߱� ������ �����մϴ�."); 	// Ŭ���̾�Ʈ�� ������ ����

			int oout=0; //�� ���� Ƚ���� �����ϱ� ���� ����
			while (true) {
				int strike=0;
				int ball=0;
				dos.writeUTF("�� ���� ��� �Ἥ �Է����ּ���(ex: 1 2 3)");

				String a = dis.readUTF(); // Ŭ���̾�Ʈ�� �Է��� ������ ����
				System.out.println("Ŭ���̾�Ʈ�� �Է��� �� -> " + a);

				StringTokenizer st = new StringTokenizer(a," "); // �Է¹��� �����͸� ���� �������� ����

				int [] nnum=new int [3]; // Ŭ���̾�Ʈ�� �Է��� ���� ���������� ����
				for(int i=0; i<3;i++) {
					nnum[i]=Integer.parseInt(st.nextToken());
				}

				for(int i=0; i<3; i++) { // ��Ģ�� �°� strike�� ball ����
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

				String str=strike+"��Ʈ����ũ "+ball+"��   ("+oout+")��°";
				System.out.println(str);
				dos.writeUTF(str); //����� Ŭ���̾�Ʈ�� ����

				oout++; //��Ģ�� �°� 3strike�̸� ������, Ŭ���̾�Ʈ ��/ Ƚ�� 9ȸ �ʰ��� ������, Ŭ���̾�Ʈ ��
				if(strike==3) {
					System.out.println("�����й�");
					dos.writeUTF("lose");
					break;
				}
				else if(oout>=10) {
					dos.writeUTF("win");
					System.out.println("�����¸�");
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
			System.out.println("�����߻�");
			e.printStackTrace();
		}
	}
}