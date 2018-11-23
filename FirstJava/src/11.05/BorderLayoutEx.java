package chap09;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx extends JFrame{
	//JFrame의 기본 레이아웃은 BorderLayout
	//setLayout(new BorderLayout());
	public BorderLayoutEx() {
		setTitle("BorderLayoutEx");
		//setLayout(new BorderLayout());
		JButton north = new JButton("NORTH");
		JButton east = new JButton("EAST");
		JButton west = new JButton("WEST");
		JButton south = new JButton("SOUTH");
		JButton center = new JButton("CENTER");
		add(BorderLayout.NORTH,north);
		//add(BorderLayout.EAST,east);
		//add(BorderLayout.WEST,west);
		add(BorderLayout.SOUTH,south);
		add(BorderLayout.CENTER,center);
		setSize(400, 400);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new BorderLayoutEx();
	}

}
