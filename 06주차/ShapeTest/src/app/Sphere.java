package app;

import lib.Shape2D;
import lib.Shape3D;
import lib.ValuePI;

public class Sphere implements Shape2D, Shape3D, ValuePI, Comparable<Sphere>{
	private double radius;
	public Sphere(double radius)
	{
		this.radius=radius;
	}
	public double findarea() {return radius*radius*PI;}
	public double findvolume() {return 4/3*radius*radius*radius*PI;}
	@Override	//sphere 크기 비교(부피 기준)
	public int compareTo(Sphere s) {
		// TODO Auto-generated method stub
		if(this.findvolume()>s.findvolume()) {return 1;}
		else if(this.findvolume()==s.findvolume()) {return 0;}
		else return -1;
	}
}
