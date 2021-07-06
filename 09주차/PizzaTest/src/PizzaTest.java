import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener{
	private JButton order_button, cancle_button;
	private int sum, t1, t2, t3;
	private JTextField text;
	private JPanel down_panel;
	WelcomePanel welcome_panel = new WelcomePanel();
	TypePanel typepanel=new TypePanel();
	ToppingPanel toppingpanel=new ToppingPanel();
	SizePanel sizepanel=new SizePanel();
	MyFrame(){
		setSize(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�����ֹ�");
		order_button=new JButton("�ֹ�");
		order_button.addActionListener(this);
		cancle_button=new JButton("���");
		cancle_button.addActionListener(this);
		text=new JTextField();
		text.setEditable(false);//�����Ұ�
		text.setColumns(10);
		down_panel=new JPanel();
		down_panel.add(order_button);
		down_panel.add(cancle_button);
		down_panel.add(text);
		setLayout(new BorderLayout());
		add(welcome_panel, BorderLayout.NORTH);
		add(typepanel, BorderLayout.WEST);
		add(toppingpanel, BorderLayout.CENTER);
		add(sizepanel, BorderLayout.EAST);
		add(down_panel, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==order_button)
		{
			t1=typepanel.getType();
			t2=0;
			t3=0;
		}
		if(e.getSource()==cancle_button)
		{
			t1=0;
			t2=0;
			t3=0;
			sum=0;
		}
		sum=t1+t2+t3;
		text.setText(" "+sum);
	}
}

class WelcomePanel extends JPanel{
	private JLabel message;
	public WelcomePanel() {
		message=new JLabel("���� ���ڿ� ���� ���� ȯ���մϴ�.");
		add(message);
	}
}

class TypePanel extends JPanel implements ActionListener{
	private JRadioButton combo, potato, bulgogi;
	private ButtonGroup bg;
	private int t_pay;
	private void setType(int p)
	{
		t_pay=p;
	}
	public int getType() {return t_pay;}
	public TypePanel() {
		setLayout(new GridLayout(3,1));
		combo=new JRadioButton("�޺�", true);
		combo.addActionListener(this);
		potato=new JRadioButton("��������");
		potato.addActionListener(this);
		bulgogi=new JRadioButton("�Ұ��");
		bulgogi.addActionListener(this);
		bg=new ButtonGroup();
		bg.add(combo);
		bg.add(potato);
		bg.add(bulgogi);
		setBorder(BorderFactory.createTitledBorder("����"));
		add(combo);
		add(potato);
		add(bulgogi);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==combo)
		{
			setType(20000);
		}
		else if(e.getSource()==potato)
		{
			setType(25000);
		}
		else
		{
			setType(30000);
		}
	}
}

/*class TypePanel extends JComponent{ 
	public TypePanel() {
		String[] kinds = {"�޺�", "��������", "�Ұ��"};
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new JLabel("����"));
		add(new JComboBox(kinds));
	}
}*/

class ToppingPanel extends JPanel{
	private JRadioButton pepper, cheese, peperoni, bacon;
	private ButtonGroup bg;
	public ToppingPanel() {
		setLayout(new GridLayout(4,1));
		pepper=new JRadioButton("�Ǹ�", true);
		cheese=new JRadioButton("ġ��");
		peperoni=new JRadioButton("���۷δ�");
		bacon=new JRadioButton("������");
		bg=new ButtonGroup();
		bg.add(pepper);
		bg.add(cheese);
		bg.add(peperoni);
		bg.add(bacon);
		setBorder(BorderFactory.createTitledBorder("�߰�����"));
		add(pepper);
		add(cheese);
		add(peperoni);
		add(bacon);
	}
}

class SizePanel extends JPanel{
	private JRadioButton small, medium, large;
	private ButtonGroup bg;
	public SizePanel() {
		setLayout(new GridLayout(4,1));
		small=new JRadioButton("small", true);
		medium=new JRadioButton("medium");
		large=new JRadioButton("large");
		
		bg=new ButtonGroup();
		bg.add(small);
		bg.add(medium);
		bg.add(large);

		setBorder(BorderFactory.createTitledBorder("�߰�����"));
		add(small);
		add(medium);
		add(large);
	}
}

public class PizzaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame f= new MyFrame();
	}

}
