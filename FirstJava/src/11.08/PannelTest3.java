package chap09;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PannelTest3 extends Frame implements ActionListener{
 public PannelTest3() {
		System.out.println("버튼생성");
		setLayout(new FlowLayout()); //차례대로 배치
		Button b1 = new Button("버튼1");
		Button b2 = new Button("버튼2");
		
		add(b1);
		add(b2);
		//addWindowListener(this); //창 닫기 버튼 
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		b1.addActionListener(this);
		b2.addActionListener(this);
		setSize(300,400);
		setVisible(true);
	}
 public void actionPerformed(ActionEvent a) {
	 String str = a.getActionCommand();
	 if(str.equals("버튼1")) {
		 System.out.println("버튼1 이벤트발생");
		 setBackground(Color.YELLOW);
	 }else {
		 System.out.println("버튼2 이벤트발생");
		 setBackground(Color.GREEN);
	 }
 }

	public static void main(String[] args) {
		new PannelTest3();
  }
	
		
//	public void windowClosing(WindowEvent e) {
//		System.exit(0);
//		
//	}
	}
