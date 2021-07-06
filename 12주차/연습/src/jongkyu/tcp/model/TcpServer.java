package jongkyu.tcp.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;

public class TcpServer {
	public static void main(String[] args) {
		ServerSocket ss = null;
		Random r = new Random();
		try {
			ss = new ServerSocket(7777);// �������� ���������� ��
			System.out.println("���� ������ ���� �Ͽ����ϴ�.");
			System.out.println("Ŭ���̾�Ʈ�� ������ ��ٸ��ϴ� . . . . . .");
			Socket so = ss.accept();// �갡 ������ ������ ��ٸ��� ���̴�.
			System.out.println(getTime() + so.getInetAddress() + "�κ��� ���Ӽ���");// ��û���� IP ����´�.
			String numb=null;
			int [] ran=new int [3];
			for(int i=0; i<ran.length; i++) {//i���� �����ؼ� ran�� ���̱��� i�ǰ��� �������״�.
				ran[i]=r.nextInt(10)+1;//ran�迭�� i��°��  ���� ���� �־���.
				for(int j=0; j<i; j++) {//���⼭���ʹ� �ߺ��˻� �ҽ��̴�.
					if(ran[i]==ran[j]) {//�ߺ��˻�ҽ��̴�.
						i--;//������� �ٽ� i�� �Է��ϰԲ� �ҷ��� ���ư���.
						break;//���� for������ ���ߵǴ� �ٽ� ���ư���.
					}
				}
			}

			numb=ran[0]+" "+ran[1]+" "+ran[2];//�̰� ���� ������ �׳� ǥ���ϱ� ���ؼ��̴�. �Ʒ����� �׳� �����ȸ���� �ص� ����� ����.
			System.out.println("���� ���� ->"+numb);

			InputStream in = so.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			OutputStream out = so.getOutputStream();// ������� ������ �ƿ�ǲ��Ʈ���ְڴ�.
			DataOutputStream dos = new DataOutputStream(out);

			dos.writeUTF("�߱� ������ �����մϴ�.");//ó���� ���� ���̴�.

			int oout=0;//�̰� �� ������ �� 10�� �Դٰ����Ұ�� ������ �̱�Բ� �ϱ� ���ؼ��̴�.
			while (true) {//�ݺ���Ų ������ �ݺ��ҷ���
				int strike=0;
				int ball=0;
				dos.writeUTF("�� ���� �Է����ּ���(ex: 1 2 3)");

				String a = dis.readUTF();
				System.out.println("Ŭ���̾�Ʈ�� �Է��� �� -> " + a);

				StringTokenizer st = new StringTokenizer(a," ");

				int [] nnum=new int [3];
				for(int i=0; i<3;i++) {
					nnum[i]=Integer.parseInt(st.nextToken());//�Է¹�����
				}

				for(int i=0; i<3; i++) {
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

				String str=strike+" ��Ʈ����ũ "+ball+" ��   ("+oout+"  )��°";
				System.out.println(str);
				dos.writeUTF(str);

				oout++;
				if(oout>=10) {
					dos.writeUTF("win");
					System.out.println("�����¸�");
					break;
				}
				else if(strike==3) {
					System.out.println("�����й�");
					dos.writeUTF("lose");
					break;
				}
				else {
					dos.writeUTF("");
				}
			}
			dos.close();
			dis.close();
			so.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //
	}

	// }
	static String getTime() {// �޼ҵ� ������ �Ȼ������. static�ϰ�쿡
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}

}