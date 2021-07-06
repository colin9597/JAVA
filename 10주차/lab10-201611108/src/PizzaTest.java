import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class CountPanel extends JPanel {
	 private JTextField count;
	 private JLabel label;
	 public CountPanel() {
		 count = new JTextField(10);
		 label = new JLabel("주문수량입력");
		 setLayout(new GridLayout(2, 1));
		 add(label);
		 add(count);
	 }
	 public JTextField getcnt() {return count;}
}

class SizePanel extends JPanel implements ActionListener{
	 private JComboBox<String> size;
	 private JLabel label;
	 private int size_pay;
	 private void setsz(int p)
	 {
		 size_pay=p;
	 }
	 public int getsz() {return size_pay;}
	 public SizePanel() {
		 String[] types = {"small", "medium", "large"};
		 setLayout(new FlowLayout());
		 label = new JLabel("사이즈");
		 size = new JComboBox<>(types);
		 size.setSelectedIndex(0);
		 size.addActionListener(this);
		 add(label);
		 add(size);
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String choice = size.getSelectedItem().toString();
		if(choice=="small")
		{
			setsz(0);
		}
		else if(choice=="medium")
		{
			setsz(3000);
		}
		else
		{
			setsz(5000);
		}
	}
}

class ToppingPanel extends JPanel implements ActionListener{
	 private JCheckBox pepper, cheese, peperoni, bacon;
	 private ButtonGroup buttonGroup;
	 private int top_pay;
	 private void setTop(int p)
	 {
		 top_pay=p;
	 }
	 public int getTop() {return top_pay;}
	 public ToppingPanel() {
		 setLayout(new GridLayout(4, 1));
		 pepper = new JCheckBox("피망", true);
		 pepper.addActionListener(this);
		 cheese = new JCheckBox("치즈");
		 cheese.addActionListener(this);
		 peperoni = new JCheckBox("페페로니");
		 peperoni.addActionListener(this);
		 bacon = new JCheckBox("베이컨");
		 bacon.addActionListener(this);
		 buttonGroup = new ButtonGroup();
		 buttonGroup.add(pepper);
		 buttonGroup.add(cheese);
		 buttonGroup.add(peperoni);
		 buttonGroup.add(bacon);
		 setBorder(BorderFactory.createTitledBorder("추가토핑"));//버튼 그룹 정리
		 add(pepper);
		 add(cheese);
		 add(peperoni);
		 add(bacon);
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==pepper)
		{
			setTop(1000);
		}
		else if(e.getSource()==cheese)
		{
			setTop(2000);
		}
		else if(e.getSource()==peperoni)
		{
			setTop(2500);
		}
		else
		{
			setTop(2800);
		}
	}
}

class TypePanel extends JPanel implements ActionListener{
	 private JComboBox<String> type;
	 private JLabel label;
	 private int t_pay;
	 private void setType(int p)
	{
		t_pay=p;
	}
	 public int getType() {return t_pay;}
	 public TypePanel() {
		 String[] types = {"콤보", "포테이토", "불고기"};
		 setLayout(new FlowLayout());
		 label = new JLabel("종류");
		 type = new JComboBox<>(types);
		 type.setSelectedIndex(0);
		 type.addActionListener(this);
		 add(label);
		 add(type);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String choice = type.getSelectedItem().toString();
		if(choice=="콤보")
		{
			setType(10000);
		}
		else if(choice=="포테이토")
		{
			setType(15000);
		}
		else
		{
			setType(20000);
		}
	}
	
}

class WelcomePanel extends JPanel {
	 private JLabel message;
	 public WelcomePanel() {
		 message = new JLabel("자바 피자에 오신 것을 환영합니다.");
		 add(message);
	 }
}

class MyFrame extends JFrame implements ActionListener{
	 private JButton orderButton, cancelButton;
	 private JTextField text;
	 private JPanel orderPanel;
	 private WelcomePanel welcomePanel = new WelcomePanel();
	 private TypePanel typePanel = new TypePanel();
	 private ToppingPanel toppingPanel = new ToppingPanel();
	 private SizePanel sizePanel = new SizePanel();
	 private CountPanel countPanel = new CountPanel();
	 private JPanel centerPanel;
	 private int sum, t1, t2, t3;
	 public MyFrame() {
		 setSize(500, 250);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setTitle("피자주문");
		 orderButton = new JButton("주문");
		 orderButton.addActionListener(this);
		 cancelButton = new JButton("취소");
		 cancelButton.addActionListener(this);
		 text = new JTextField();
		 text.setEditable(false); // 수정불가
		 text.setColumns(8); // 길이 지정
		 orderPanel=new JPanel();
		 orderPanel.add(orderButton);
		 orderPanel.add(cancelButton);
		 orderPanel.add(text);
		 centerPanel = new JPanel();
		 centerPanel.add(toppingPanel);
		 centerPanel.add(countPanel);
		 setLayout(new BorderLayout());
		 add(welcomePanel, BorderLayout.NORTH);
		 add(orderPanel, BorderLayout.SOUTH);
		 add(sizePanel, BorderLayout.EAST);
		 add(typePanel, BorderLayout.WEST);
		 add(centerPanel, BorderLayout.CENTER);
		 setVisible(true);
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==orderButton)
		{
			t1=typePanel.getType();
			t2=toppingPanel.getTop();
			t3=sizePanel.getsz();
		}
		if(e.getSource()==cancelButton)
		{
			t1=0;
			t2=0;
			t3=0;
		}
		int n;
		String tx=countPanel.getcnt().getText();
		System.out.println(tx);
		n=Integer.parseInt(tx);
		sum=(t1+t2+t3)*n;
		text.setText(" "+sum);
	}
}

public class PizzaTest {
	 public static void main(String[] args) {
		 MyFrame myFrame = new MyFrame();
	 }
} 