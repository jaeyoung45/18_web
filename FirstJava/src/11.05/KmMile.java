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

public class KmMile extends JFrame implements ActionListener{
		JPanel p1, p2;
		JButton b1;
		JTextField tf1 ,tf2;
	public KmMile() {
		//setLayout(new BorderLayout());
		p1 = new JPanel(new FlowLayout()); //JPanel 기본레이아웃 FlowLayout
		tf1 = new JTextField(10);
		p1.add(new JLabel("Km 입력"));
		p1.add(tf1);
		
		b1 = new JButton("변환");
		
		p2 = new JPanel();
		p2.add(new JLabel("결과"));
		tf2 = new JTextField(10);
		p2.add(tf2);
	
		add(BorderLayout.NORTH,p1);
		add(BorderLayout.CENTER,b1);
		add(BorderLayout.SOUTH,p2);
				
		setSize(300,150);
		setVisible(true);
		b1.addActionListener(this);
		
		
	}	
	
	public static void main(String[] args) {
		new KmMile();
	}
	public void actionPerformed(ActionEvent e) {
		int km = Integer.parseInt(tf1.getText());
		tf2.setText(km*0.62+"");
		
	
	}
}

