package app;

import lib.ValuePI;
import java.util.Scanner;

public class Driver implements ValuePI{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sphere sphere = new Sphere(2);
		try{Box box = new Box(2, 3, 4);
		
		System.out.println("���� ���̴� " + sphere.findarea() + "�̴�.");
		System.out.println("���� ���Ǵ� " + sphere.findvolume() + "�̴�.");
		System.out.println("�ڽ��� �ٴ��� ������ " + box.findarea() + "�̴�.");
		System.out.println("�ڽ��� ���Ǵ� " + box.findvolume() + "�̴�.");
		}
		catch(InputException e) {
			System.out.println(e.getMessage());
		}
		
		//�߰� ����
		System.out.println("\n-�߰�����-");
		System.out.println("Sphere�� ������ PI�� : "+PI+"\n");
		
		Sphere newsphere = new Sphere(2);	//�������� 2�� sphere ����
		System.out.println("�������� 2�� newsphere ����=>");
		if(sphere.compareTo(newsphere)==0) {System.out.println("ó���� ������ sphere�� ũ�Ⱑ ����.");}
		else if(sphere.compareTo(newsphere)==1){System.out.println("sphere�� newsphere ���� ũ��.");}
		else {System.out.println("newsphere�� sphere ���� Ů�ϴ�.");}
		System.out.println("���� ���̴� " + newsphere.findarea() + "�̴�.");
		System.out.println("���� ���Ǵ� " + newsphere.findvolume() + "�̴�.\n");
		
		Scanner scan=new Scanner(System.in);
		double _length, _width, _height;
		System.out.println("���� : ");
		_length=scan.nextInt();
		System.out.println("���� : ");
		_width=scan.nextInt();
		System.out.println("���� : ");
		_height=scan.nextInt();
		try {
			Box newbox = new Box(_length, _width, _height);
			System.out.println("�ڽ��� �ٴ��� ������ " + newbox.findarea() + "�̴�.");
			System.out.println("�ڽ��� ���Ǵ� " + newbox.findvolume() + "�̴�.");
		}
		catch(InputException e) {
			System.out.println(e.getMessage());
		}
	}

}
