package chap09;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MessageBox extends JFrame{
	public MessageBox(String title, String msg) {
		setTitle(title);
		setLayout(new FlowLayout());
		JButton closeBtn = new JButton("´Ý±â");
		JLabel lbl = new JLabel(msg);
		add(lbl);
		add(closeBtn);
		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				setVisible(false);
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
			
		});
		setSize(300, 200);
		setVisible(true);
	}
}