package chap09;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridLayoutEx extends JFrame{
	public GridLayoutEx() {
		setTitle("�׸��巹�̾ƿ�");
		setLayout(new GridLayout(4,2));
		add(new JLabel("�̸�"));
		add(new JTextField());
		add(new JLabel("�ּ�"));
		add(new JTextField());
		add(new JLabel("����"));
		add(new JTextField());
		add(new JButton("Ȯ��"));
		add(new JButton("���"));
		setSize(400, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GridLayoutEx();

	}

}
