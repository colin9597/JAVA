class Time
{
	private int hour;
	private int minute;
	private int second;
	public static int tCount;
	public Time() {
		this(0, 0, 0);
	}
	public Time(int hour, int minute, int second) {
		this.hour=hour;
		this.minute=minute;
		this.second=second;
	}
	static
	{
		tCount=0;
	}
	{
		tCount++;
	}
	public void timePrn() {
		//System.out.println(hour+":"+minute+":"+second);
		System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
	}
	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof Time)) return false;
		Time t=(Time)obj;
		
		return this.hour==t.hour&&this.minute==t.minute&&this.second==t.second;
	}
}
public class TimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time t1=new Time(13, 27, 6);
		Time t2=new Time();
		//t1.timePrn();
		//t2.timePrn();
		System.out.println(t1);
		System.out.println(t2);
		System.out.println("현재까지 생산한 시계는 총"+Time.tCount+"개입니다.");
		System.out.println(t1.equals(t2)?"시각일치":"시각다름");
		
	}

	

}
