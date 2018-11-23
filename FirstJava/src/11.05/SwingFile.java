package chap09;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingFile extends JFrame implements ActionListener{
	private JTextField tf;
	private JTextArea ta;
	public SwingFile() {
		setLayout(new FlowLayout());
		tf = new JTextField(20);
		JButton btn = new JButton("�б�");
		JButton btn1 = new JButton("����");
		ta = new JTextArea(20,40);
		JScrollPane jsp = new JScrollPane(ta);
		add(tf);
		add(btn);
		add(btn1);
		add(jsp);
		setSize(500,500);
		btn.addActionListener(this);
		btn1.addActionListener(this);
		//tf.addActionListener(this);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingFile();
}
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand(); //��ư���� �ִ� ����
		String fileName = tf.getText();
		if(str.equals("�б�")) {
		try {
			Scanner sc = new Scanner(new File(fileName));
			while(sc.hasNext()) {
				ta.append(sc.nextLine()+"\n");
				}
				sc.close();
			}catch(FileNotFoundException f) {
				f.printStackTrace();
				tf.setText("������ �����!!!");
			}	
		} else if(str.equals("����")) {
			try {
			FileWriter fw = new FileWriter(fileName);
			fw.write(ta.getText());
			fw.close();
	}catch(IOException e1) {
		e1.printStackTrace();
	}
}
	}
}
