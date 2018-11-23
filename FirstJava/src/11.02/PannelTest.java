package chap09;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PannelTest extends Frame implements ActionListener{
 public PannelTest() {
		System.out.println("��ư����");
		setLayout(new FlowLayout()); //���ʴ�� ��ġ
		Button b1 = new Button("��ư1");
		Button b2 = new Button("��ư2");
		
		add(b1);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setSize(300,400);
		setVisible(true);
	}
 public void actionPerformed(ActionEvent a) {
	 String str = a.getActionCommand();
	 if(str.equals("��ư1")) {
		 System.out.println("��ư1 �̺�Ʈ�߻�");
		 setBackground(Color.YELLOW);
	 }else {
		 System.out.println("��ư2 �̺�Ʈ�߻�");
		 setBackground(Color.GREEN);
	 }
 }

	public static void main(String[] args) {
		new PannelTest();
  }
}
