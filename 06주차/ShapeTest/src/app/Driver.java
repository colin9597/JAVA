package app;

import lib.ValuePI;
import java.util.Scanner;

public class Driver implements ValuePI{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sphere sphere = new Sphere(2);
		try{Box box = new Box(2, 3, 4);
		
		System.out.println("원의 넓이는 " + sphere.findarea() + "이다.");
		System.out.println("구의 부피는 " + sphere.findvolume() + "이다.");
		System.out.println("박스의 바닥의 면적은 " + box.findarea() + "이다.");
		System.out.println("박스의 부피는 " + box.findvolume() + "이다.");
		}
		catch(InputException e) {
			System.out.println(e.getMessage());
		}
		
		//추가 문제
		System.out.println("\n-추가문제-");
		System.out.println("Sphere에 구현된 PI값 : "+PI+"\n");
		
		Sphere newsphere = new Sphere(2);	//반지름이 2인 sphere 생성
		System.out.println("반지름이 2인 newsphere 생성=>");
		if(sphere.compareTo(newsphere)==0) {System.out.println("처음에 생성된 sphere와 크기가 같다.");}
		else if(sphere.compareTo(newsphere)==1){System.out.println("sphere가 newsphere 보다 크다.");}
		else {System.out.println("newsphere가 sphere 보다 큽니다.");}
		System.out.println("원의 넓이는 " + newsphere.findarea() + "이다.");
		System.out.println("구의 부피는 " + newsphere.findvolume() + "이다.\n");
		
		Scanner scan=new Scanner(System.in);
		double _length, _width, _height;
		System.out.println("가로 : ");
		_length=scan.nextInt();
		System.out.println("세로 : ");
		_width=scan.nextInt();
		System.out.println("높이 : ");
		_height=scan.nextInt();
		try {
			Box newbox = new Box(_length, _width, _height);
			System.out.println("박스의 바닥의 면적은 " + newbox.findarea() + "이다.");
			System.out.println("박스의 부피는 " + newbox.findvolume() + "이다.");
		}
		catch(InputException e) {
			System.out.println(e.getMessage());
		}
	}

}
