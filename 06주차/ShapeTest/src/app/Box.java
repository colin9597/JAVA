package app;

import lib.Shape2D;
import lib.Shape3D;
import lib.ValuePI;	// Box 클래스에서는 PI값이 필요없으나 문제에서 사용하라 했으므로 추가합니다.

public class Box implements Shape2D, Shape3D, ValuePI{
	private double length;
	private double width;
	private double height;
	public Box(double length, double width, double height)throws InputException{
		if(length<=0 | width <=0 | height <=0) {
			throw new InputException("가로, 세로, 높이 값은 0이하일 수 없음.");
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
