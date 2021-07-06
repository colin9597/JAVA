
public class lab1_201611108 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long lightspeed;		//결과값이 큰 수이기 때문에 자료형을 long으로 변경
		long distance;
		
		lightspeed=300000L;
		distance=lightspeed*365*24*60*60L;
		
		System.out.println("빛이 1년동안 움직이는 거리는 " + distance + "km");
	}

}
