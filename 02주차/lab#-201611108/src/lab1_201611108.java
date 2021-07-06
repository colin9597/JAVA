import java.util.Scanner;								//Scanner 클래스 사용

public class lab1_201611108 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner input=new Scanner(System.in);	//Scanner 객체 생성
		int a, b;
		
		System.out.println("입력 : ");					//a, b 값 입력
		a=input.nextInt();
		b=input.nextInt();
		
		while(a==0) {									//a!=0
			System.out.println("a!=0, 다시 입력해주세요.");
			a=input.nextInt();
			b=input.nextInt();
		}
			
		if(b%a==0) {									//출력
			System.out.println("출력 :");
			System.out.println(a+" | " + b);
		}
		else {
			System.out.println("출력 :");
			System.out.println(a+" !| "+ b);
		}
	}
		
		
}

