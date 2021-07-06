package app;

import lib.Shape2D;
import lib.Shape3D;
import lib.ValuePI;	// Box Ŭ���������� PI���� �ʿ������ �������� ����϶� �����Ƿ� �߰��մϴ�.

public class Box implements Shape2D, Shape3D, ValuePI{
	private double length;
	private double width;
	private double height;
	public Box(double length, double width, double height)throws InputException{
		if(length<=0 | width <=0 | height <=0) {
			throw new InputException("����, ����, ���� ���� 0������ �� ����.");
		}
		else {
			this.length=length;
			this.width=width;
			this.height=height;
		}
	}
	public double findarea() {return length*width;}
	public double findvolume() {return length*width*height;}
}
