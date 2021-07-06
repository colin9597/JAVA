package week4;

public class Circle extends Shape {
	private final double PI=3.1415192;
	private double radius;
	private Point center;
	public Circle(double radius, String color, float x, float y)
	{
		super(color);
		center=new Point(x,y);
		this.radius=radius;
	}
	public double getArea()
	{
		return radius*radius*PI;
	}
	public void draw()
	{
		System.out.println("Circle ");
		System.out.println("Center : " + center + ", lineColor : " + getLineColor());
		System.out.printf("%6.2f%n", radius);
	}
}
