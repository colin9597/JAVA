package week4;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Shape> Shapes=new ArrayList<>();
		Circle c1=new Circle(10, "red", 0F, 5.5F);
		Triangle t1=new Triangle(0F, 0F, 10F, 0F, 20F, 20F, 20F, 10F);
		c1.draw();
		System.out.println("≥–¿Ã : "+c1.getArea());
		t1.draw();
		System.out.println("≥–¿Ã : "+t1.getArea());
		Shapes.add(c1);
		Shapes.add(t1);
		for(Shape s: Shapes)
		{
			s.draw();
		}
	}

}
