
public class lab2_201611108 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float radius = 5.0f;					//반지름 대입
		float area = radius*radius*3.141592f;	//면적 계산
		float perimeter = 2*radius*3.141592f;	//둘레 계산
		
		System.out.println("원의 면적은 " + area);	//면적 출력
		System.out.printf("원의 둘레는 %.2f", perimeter);	//둘레 출력, 둘레는 소수점 둘째자리까지 표현

	}

}
