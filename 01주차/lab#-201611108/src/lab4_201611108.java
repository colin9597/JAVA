
public class lab4_201611108 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=3, b=5;
		//System.out.println(a+"와 "+b+"의 차이는 "+Math.abs(a-b));	//조건문 미사용시
		System.out.println(a+"와 "+b+"의 차이는 "+((a>b)?a-b:b-a));	//조건문 사용시
	}

}
