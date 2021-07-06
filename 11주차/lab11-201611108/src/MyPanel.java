import java.awt.*;
import javax.swing.*;
//공을 Ball 클래스로 모델링한다. 
class Ball {
	//공의 속성은 위치, 크기, 속도이다. 
	private int x = 100;
	private int y = 100;
	private int size = 30;
	private int xSpeed = 10;
	private int ySpeed = 10;
	
	//공을 화면에 그려주는 메소드이다. 
	public void draw(Graphics g) {
		//여기에 코드를 
		g.setColor(Color.RED); 			//그래픽 색상지정
		g.fillOval(x, y, size, size);	//속이 꽉찬 원 그리기 , (x,y)위치에 sizeXsize크기
	}
	public void update(int BOARD_WIDTH, int BOARD_HEIGHT) {		
		if((x+xSpeed)>=(BOARD_WIDTH-size) || x<=0) {xSpeed*=-1;}
		if((y+ySpeed)>=(BOARD_HEIGHT-(2*size)) || y<=0) {ySpeed*=-1;}	// 보드의 높이가 300이라 했는데, frame의 높이를 300으로 설정했므로 
		
		x+=xSpeed;
		y+=ySpeed;
		
		//공의 새로운 위치를 계산한다. 공이 벽에 부딪치면 반사되도록 한다. 
		//공은 xSpeed, ySpeed만큼 위치가 이동한다. 
		//xSpeed, ySpeed, x,y,BOARD_WIDTH, BOARD_HEIGT값을 사용하여 작성
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
				ball.update(BOARD_WIDTH, BOARD_HEIGHT); 		//ball객체의 update()호출
				repaint();										//다시 그리기
				try {
					Thread.sleep(50);
				}catch(InterruptedException e) {
					return;
				}
			}
		};									//람다식을 이용하여서 Runnable 객체를 생성한다.
											//무한루프를 돌면서 공의 위치를 변경하고 화면에 다시 그린다. 50 밀리초동안 쉰다. 
											
		Thread th = new Thread(runnable);
		th.start(); 	//스레드 객체를 생성하고 스레드를 실행시킨다.
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