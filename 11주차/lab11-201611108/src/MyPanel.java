import java.awt.*;
import javax.swing.*;
//���� Ball Ŭ������ �𵨸��Ѵ�. 
class Ball {
	//���� �Ӽ��� ��ġ, ũ��, �ӵ��̴�. 
	private int x = 100;
	private int y = 100;
	private int size = 30;
	private int xSpeed = 10;
	private int ySpeed = 10;
	
	//���� ȭ�鿡 �׷��ִ� �޼ҵ��̴�. 
	public void draw(Graphics g) {
		//���⿡ �ڵ带 
		g.setColor(Color.RED); 			//�׷��� ��������
		g.fillOval(x, y, size, size);	//���� ���� �� �׸��� , (x,y)��ġ�� sizeXsizeũ��
	}
	public void update(int BOARD_WIDTH, int BOARD_HEIGHT) {		
		if((x+xSpeed)>=(BOARD_WIDTH-size) || x<=0) {xSpeed*=-1;}
		if((y+ySpeed)>=(BOARD_HEIGHT-(2*size)) || y<=0) {ySpeed*=-1;}	// ������ ���̰� 300�̶� �ߴµ�, frame�� ���̸� 300���� �����߹Ƿ� 
		
		x+=xSpeed;
		y+=ySpeed;
		
		//���� ���ο� ��ġ�� ����Ѵ�. ���� ���� �ε�ġ�� �ݻ�ǵ��� �Ѵ�. 
		//���� xSpeed, ySpeed��ŭ ��ġ�� �̵��Ѵ�. 
		//xSpeed, ySpeed, x,y,BOARD_WIDTH, BOARD_HEIGT���� ����Ͽ� �ۼ�
	}
}


public class MyPanel extends JPanel {
	static final int BOARD_WIDTH = 600;
	static final int BOARD_HEIGHT = 300;
	private Ball ball = new Ball();
	public MyPanel() {
		this.setBackground(Color.YELLOW);
		Runnable runnable=()->{
			while(true) {
				ball.update(BOARD_WIDTH, BOARD_HEIGHT); 		//ball��ü�� update()ȣ��
				repaint();										//�ٽ� �׸���
				try {
					Thread.sleep(50);
				}catch(InterruptedException e) {
					return;
				}
			}
		};									//���ٽ��� �̿��Ͽ��� Runnable ��ü�� �����Ѵ�.
											//���ѷ����� ���鼭 ���� ��ġ�� �����ϰ� ȭ�鿡 �ٽ� �׸���. 50 �и��ʵ��� ����. 
											
		Thread th = new Thread(runnable);
		th.start(); 	//������ ��ü�� �����ϰ� �����带 �����Ų��.
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ball.draw(g);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(MyPanel.BOARD_WIDTH, MyPanel.BOARD_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(new MyPanel());
	}
}