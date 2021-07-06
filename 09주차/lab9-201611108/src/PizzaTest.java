import java.awt.*;
import javax.swing.*;

class MyFrame extends JFrame{
	private JButton order_button, cancle_button;
	private JTextField text;
	private JPanel down_panel;
	WelcomePanel welcome_panel = new WelcomePanel();
	TypePanel typepanel=new TypePanel();
	//ToppingPanel toppingpanel=new ToppingPanel();
	//VolumePanel volumepanel=new VolumePanel();
	TVPanel tvpanel = new TVPanel();
	SizePanel sizepanel=new SizePanel();
	MyFrame(){
		setSize(480, 240);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("201611108 김동현");
		order_button=new JButton("주문");
		cancle_button=new JButton("취소");
		text=new JTextField();
		text.setEditable(false);//수정불가
		text.setColumns(6);
		down_panel=new JPanel();
		down_panel.add(order_button);
		down_panel.add(cancle_button);
		down_panel.add(text);
		setLayout(new BorderLayout());
		add(welcome_panel, BorderLayout.NORTH);
		add(typepanel, BorderLayout.WEST);
		add(tvpanel, BorderLayout.CENTER);
		add(sizepanel, BorderLayout.EAST);
		add(down_panel, BorderLayout.SOUTH);
		
		setVisible(true);
	}
}

class WelcomePanel extends JPanel{
	private JLabel message;
	public WelcomePanel() {
		message=new JLabel("자바 피자에 오신 것을 환영합니다.");
		add(message);
	}
}

class TypePanel extends JPanel{ 
	private JLabel kind_label;
	private JComboBox kind_combo;
	public TypePanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		String[] kinds = {"콤보", "포테이토", "불고기"};
		kind_label = new JLabel("종류");
		kind_combo = new JComboBox(kinds);
		add(kind_label);
		add(kind_label);
		add(kind_combo);
	}
}

class ToppingPanel extends JPanel{
	private JCheckBox pepper, cheese, peperoni, bacon;
	//private ButtonGroup bg;
	public ToppingPanel() {
		setLayout(new GridLayout(4,1));
		pepper=new JCheckBox("피망", true);
		cheese=new JCheckBox("치즈");
		peperoni=new JCheckBox("페퍼로니");
		bacon=new JCheckBox("베이컨");
		/*bg=new ButtonGroup();
		bg.add(pepper);
		bg.add(cheese);
		bg.add(peperoni);
		bg.add(bacon);*/
		setBorder(BorderFactory.createTitledBorder("추가토핑"));
		add(pepper);
		add(cheese);
		add(peperoni);
		add(bacon);
	}
}

class VolumePanel extends JPanel{
	private JTextField vol_text;
	private JLabel vol_label;
	public VolumePanel() {
		//setLayout(new FlowLayout(FlowLayout.LEFT));
		setLayout(new GridLayout(6,1));
		vol_label=new JLabel("주문수량입력");
		vol_text=new JTextField(9);
		add(new JLabel(""));
		add(new JLabel(""));
		add(vol_label);
		add(vol_text);
		add(new JLabel(""));
		add(new JLabel(""));
	}
}

class TVPanel extends JPanel{
	public TVPanel() {
		setLayout(new GridLayout(1,2,5,0));
		add(new ToppingPanel());
		add(new VolumePanel());
	}
}

class SizePanel extends JPanel{
	private JLabel size_label;
	private JComboBox size_combo;
	public SizePanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		String[] size = {"small", "medium", "large"};
		size_label=new JLabel("사이즈");
		size_combo=new JComboBox(size);
		add(size_label);
		add(size_combo);
	}
}

public class PizzaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame f= new MyFrame();
	}

}
