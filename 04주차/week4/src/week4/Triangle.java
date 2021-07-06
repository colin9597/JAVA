package week4;

public class Triangle extends Shape {
	private float width;
	private float height;
	public Triangle(float x1, float y1, float x2, float y2, float x3, float y3, float w, float h)
	{
		width = w;
		height = h;
		addPoint(x1, y1);
		addPoint(x2, y2);
		addPoint(x3, y3);
		
	}
	public void draw()
	{
		System.out.println("Triangle");
		super.draw();
		System.out.println("LineColor : "+getLineColor());
	}
	public double getArea()
	{
		return width*height*0.5;
	}
}
