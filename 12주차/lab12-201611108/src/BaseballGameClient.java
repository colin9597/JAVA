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
			System.out.println("������ �������Դϴ�.....");
			Socket so = new Socket("localhost", 7777); //Ŭ���̾�Ʈ ���� ���� �� ������ ����
			
			InputStream in = so.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			OutputStream out = so.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);

			System.out.println(dis.readUTF()); //"�߱� ������ �����մϴ�" ���(�������� ó���� ������ ����)

			while (true) {
				System.out.println(dis.readUTF());	//"�� ���� ��� �Ἥ �Է����ּ���(ex: 1 2 3)" ���(�������� ����)		
				System.out.print("-->");
				String text = scanner.nextLine(); 	// 3���� ���ڸ� �Է¹���
				dos.writeUTF(text);					// �Է¹��� �����͸� ������ ����
				System.out.println(dis.readUTF());	// ��� ����(ex: 1strike 2ball (1)��°)			
				String sel =dis.readUTF();			// ������ ���� ��� ����("lose" or "win")

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
			scanner.close();
		} catch (Exception e) {
		}
	}
}