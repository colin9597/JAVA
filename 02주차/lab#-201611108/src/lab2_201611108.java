import java.util.Scanner;						//Scanner Ŭ���� ���

public class lab2_201611108 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char grade;								
		Scanner input=new Scanner(System.in);	//Scanner ��ü ����
		int[] score= new int[10];				//�ִ� 10���� �л�, array ����
		float total=0F;							//�� ���� ���� �ʱ�ȭ
		float count=0F;							//�л� �� ���� �ʱ�ȭ
		
		for (int i=0; i<10; i++) {
			do {								//0~100������ ������ �Է��� ������ ����
				System.out.println((i+1)+" : ");
				score[i]=input.nextInt();
				if(score[i]==-1) {break;}		//score=-1�̸� do~while���� ���
			}while(score[i]<0 | score[i]>100);
			if(score[i]==-1) {break;}			//score=-1�̸� for���� ���
			total+=score[i];					//�� ����
			
			switch(score[i]/10) {				//�����Ǻ� switch�� ���
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
			count+=1;							//�л� ��
		}
		System.out.printf("Average : %.2f", total/count);	//���� ��� �Ҽ����� 2�ڸ����� ���		
	}
}
