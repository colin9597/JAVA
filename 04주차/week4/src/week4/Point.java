package week4;

public class Point {
	private float x;
	private float y;
	public Point(float x, float y)
	{
		this.x=x;
		this.y=y;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str=String.format("[%5.2f, %5.2f]", x,y);
		return str;
	}
}