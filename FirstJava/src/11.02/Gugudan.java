package chap09;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gugudan extends Frame implements ActionListener{

	TextField tf;
	TextArea ta;
		public Gugudan () {
			setLayout(new FlowLayout());
			tf = new TextField(10);
			ta = new TextArea(10,20);
			Button b1 = new Button("실행");
			tf.addActionListener(this);
			add(tf);
			add(b1);
			add(ta);
			setSize(300,300);
			setVisible(true);
			b1.addActionListener(this);
		}

		public void actionPerformed(ActionEvent a) {
			ta.setText("");
			try {
			int dan = Integer.parseInt(tf.getText());
			for(int i=1; i<10; i++) {
			 ta.append(dan +"*"+i+"="+dan*i+"\n");
			}
		}catch(NumberFormatException n) {
			tf.setText("숫자를 넣으세요");
		}
	}
	public static void main(String[] args) {
		new Gugudan();
	}	
}

