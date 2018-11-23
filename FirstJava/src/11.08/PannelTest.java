package chap09;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PannelTest extends Frame implements ActionListener, WindowListener{
 public PannelTest() {
		System.out.println("버튼생성");
		setLayout(new FlowLayout()); //차례대로 배치
		Button b1 = new Button("버튼1");
		Button b2 = new Button("버튼2");
		
		add(b1);
		add(b2);
		addWindowListener(this); //창 닫기 버튼 
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
		new PannelTest();
  }
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
