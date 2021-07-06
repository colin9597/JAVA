package week4;
import java.util.ArrayList;
import java.util.List;

public abstract class Shape {
	private String lineColor;
	private List<Point> points=new ArrayList<>();
	public Shape() {lineColor="black";}
	public Shape(String lineColor)
	{
		this.lineColor=lineColor;
	}
	public void addPoint(float x, float y)
	{
		Point p=new Point(x, y);
		points.add(p);
	}
	public String getLineColor() {return lineColor;}
	public void setLineColor(String color) {lineColor = color;}
	public void draw(){
		for(Point p:points)
			System.out.print(p);
		System.out.println();
	}
	public abstract double getArea();
}
