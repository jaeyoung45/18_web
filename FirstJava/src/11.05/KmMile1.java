package chap09;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KmMile1 extends JFrame {
		JPanel p1, p2;
		JButton b1;
		JTextField tf1 ,tf2;
	public KmMile1() {
		p1 = new JPanel(new FlowLayout());
		tf1 = new JTextField(10);
		p1.add(new JLabel("Km �Է�"));
		p1.add(tf1);
		
		b1 = new JButton("��ȯ");
		
		p2 = new JPanel();
		p2.add(new JLabel("���"));
		tf2 = new JTextField(10);
		p2.add(tf2);
	
		add(BorderLayout.NORTH,p1);
		add(BorderLayout.CENTER,b1);
		add(BorderLayout.SOUTH,p2);
				
		setSize(300,150);
		setVisible(true);	
		b1.addActionListener(new EventH());
//		tf1.addActionListener(new EventH(tf1, tf2));
		
	}	
	
	public static void main(String[] args) {
		new KmMile1();
	}


class EventH implements ActionListener{
//	JTextField tf1, tf2;
//	
//	public EventH(JTextField tf1, JTextField tf2) {
//		this.tf1 = tf1;
//		this.tf2 = tf2;
//	}
	

	public void actionPerformed(ActionEvent e) {
		int km = Integer.parseInt(tf1.getText()) ;
		tf2.setText(km*0.623+"");	
	}
	
	
}
}