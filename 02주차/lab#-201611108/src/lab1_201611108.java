import java.util.Scanner;								//Scanner Ŭ���� ���

public class lab1_201611108 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner input=new Scanner(System.in);	//Scanner ��ü ����
		int a, b;
		
		System.out.println("�Է� : ");					//a, b �� �Է�
		a=input.nextInt();
		b=input.nextInt();
		
		while(a==0) {									//a!=0
			System.out.println("a!=0, �ٽ� �Է����ּ���.");
			a=input.nextInt();
			b=input.nextInt();
		}
			
		if(b%a==0) {									//���
			System.out.println("��� :");
			System.out.println(a+" | " + b);
		}
		else {
			System.out.println("��� :");
			System.out.println(a+" !| "+ b);
		}
	}
		
		
}

