package chap09;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JGugudan extends JFrame implements ActionListener {
	JTextField tf;
	JTextArea ta;
	public JGugudan() {
		setLayout(new FlowLayout());
		tf = new JTextField(10);
		JButton b1 = new JButton("½ÇÇà");
		ta = new JTextArea(10,20);
		tf.addActionListener(this);
		b1.addActionListener(this);
		JScrollPane jsp = new JScrollPane(ta);
		add(tf);	add(b1);	add(jsp);
		setSize(300,300);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent a) {
		//ta.setText("");
		int dan = Integer.parseInt(tf.getText());
		for(int i=1; i<10; i++) {
		 System.out.println(dan+"*"+i+"="+dan*i);
		 ta.append(dan +"*"+i+"="+dan*i+"\n");
		}
		
	}
	public static void main(String[] args) {
		new JGugudan();

	}

}
