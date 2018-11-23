package chap09;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

	public class JpannelTest extends JFrame implements ActionListener{
		public JpannelTest() {
			setLayout(new FlowLayout());
			JButton b1 = new JButton("button1");
			JButton b2 = new JButton("button2");
			add(b1);
			add(b2);
			b1.addActionListener(this);
			b2.addActionListener(this);
			setSize(300,400);
			setVisible(true);
		}
	public void actionPerformed(ActionEvent a) {
		String str = a.getActionCommand();
		if(str.equals("button1")){
		 System.out.println("button1 이벤트발생");
		 getContentPane().setBackground(Color.PINK);
		}else {
		 System.out.println("button2 이벤트발생");
		 getContentPane().setBackground(Color.blue);
		 setBackground(Color.pink);
		}
		
	}
	public static void main(String[] args) {
		new JpannelTest();
	}
}
