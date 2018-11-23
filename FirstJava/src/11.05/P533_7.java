package chap09;

import java.awt.BorderLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class P533_7  extends JFrame{
	public P533_7() {
		JPanel p1, p2;
		JTextField tf1, tf2;
		setTitle("계산기 프레임");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1.add(new JLabel("수식입력"));
		tf1 = new JTextField(20);
		p1.add(tf1);
		
		JButton b1 = new JButton("0");
		JButton b2 = new JButton("1");
		JButton b3 = new JButton("2");
		JButton b4 = new JButton("3");
		JButton b5 = new JButton("4");
		JButton b6 = new JButton("5");
		JButton b7 = new JButton("6");
		JButton b8 = new JButton("7");
		JButton b9 = new JButton("8");
		JButton b10 = new JButton("9");
		JButton b11 = new JButton("CE");
		JButton b12 = new JButton("계산");
		JButton b13 = new JButton("+");
		JButton b14 = new JButton("-");
		JButton b15 = new JButton("*");
		JButton b16 = new JButton("/");
		
		p2 = new JPanel();
		tf2 = new JTextField(20);
		p2.add(new JLabel("게산 결과"));
		
		
		
	}

	public static void main(String[] args) {
		new P533_7();

	}

}
