package chap09;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameEnc  extends JFrame{
	public FrameEnc() {
		setTitle("암호화/복호화");
		setLayout(new GridLayout(3,1));
		Container c = getContentPane();
		JTextField tf1 = new JTextField();
		JTextField tf2 = new JTextField();
		JPanel p = new JPanel();
		JButton b1 = new JButton("암호화");
		JButton b2 = new JButton("복호화");
		p.add(b1);
		p.add(b2);
		c.add(tf1);
		c.add(tf2);
		c.add(p);
		addWindowListener(new WindowAdapter() {
		
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		});
		b1.addActionListener(new ActionListener() { //암호화
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = encrypt(tf1.getText());
				tf2.setText(str);
			}
		});
		b2.addActionListener(new ActionListener() { //복호화
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//String str = decrypt(tf2.getText());
				//tf2.setText(str);
				tf2.setText(decrypt(tf2.getText()));
				
			}
		});
		setSize(300, 150);
		setVisible(true);
	}
		
	private  String encrypt(String str) { //암호화
		String tmp = "";
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)==' ') {
				tmp += str.charAt(i);
			}else {
				tmp +=(char)(str.charAt(i)+2);
			}
		}
		return tmp;		
	}
	private String decrypt(String str) { //복호화
		String tmp = "";
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)==' ') {
				tmp += str.charAt(i);
			}else {
				tmp +=(char)(str.charAt(i)-2);
			}
		}
		return tmp;		
	}
	
	public static void main(String[] args) {
		new FrameEnc();

	}
}


