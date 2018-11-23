package chap09;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridLayoutEx extends JFrame{
	public GridLayoutEx() {
		setTitle("그리드레이아웃");
		setLayout(new GridLayout(4,2));
		add(new JLabel("이름"));
		add(new JTextField());
		add(new JLabel("주소"));
		add(new JTextField());
		add(new JLabel("나이"));
		add(new JTextField());
		add(new JButton("확인"));
		add(new JButton("취소"));
		setSize(400, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GridLayoutEx();

	}

}
