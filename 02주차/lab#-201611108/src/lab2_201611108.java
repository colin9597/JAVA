import java.util.Scanner;						//Scanner 클래스 사용

public class lab2_201611108 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char grade;								
		Scanner input=new Scanner(System.in);	//Scanner 객체 생성
		int[] score= new int[10];				//최대 10명의 학생, array 생성
		float total=0F;							//총 점수 변수 초기화
		float count=0F;							//학생 수 변수 초기화
		
		for (int i=0; i<10; i++) {
			do {								//0~100사이의 점수를 입력할 때까지 실행
				System.out.println((i+1)+" : ");
				score[i]=input.nextInt();
				if(score[i]==-1) {break;}		//score=-1이면 do~while문을 벗어남
			}while(score[i]<0 | score[i]>100);
			if(score[i]==-1) {break;}			//score=-1이면 for문을 벗어남
			total+=score[i];					//총 점수
			
			switch(score[i]/10) {				//학점판별 switch문 사용
			case 10:
				grade = 'A';
				break;
			case 9:
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			case 6:
				grade = 'D';
				break;
			default:
				grade = 'F';
				break;
			}
			
			System.out.println("Score : " + score[i]+"("+grade+")");
			count+=1;							//학생 수
		}
		System.out.printf("Average : %.2f", total/count);	//성적 평균 소수이하 2자리까지 출력		
	}
}
