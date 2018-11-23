package chap09;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CheckBoxTest extends JFrame{
	JTextArea ta;
	public CheckBoxTest() {
		setTitle("checkboxTest");
		setLayout(new BorderLayout());
		JCheckBox cb1 = new JCheckBox("바나나");
		JCheckBox cb2 = new JCheckBox("오렌지");
		ta = new JTextArea(10,20);
		JPanel p = new JPanel();
		p.add(cb1);
		p.add(cb2);
		cb1.addItemListener(new EventI());
		cb2.addItemListener(new EventI());
		JScrollPane jsp = new JScrollPane(ta);
		add(BorderLayout.NORTH,p);
		add(BorderLayout.CENTER,jsp);
		
		
		setSize(400,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CheckBoxTest();

	}

//	public void itemStateChanged(ItemEvent arg0) {
//		JCheckBox cb = (JCheckBox) arg0.getSource();
//		if(cb.isSelected()) {
//			ta.append(cb.getText()+"선택\n");
//		}else {
//			ta.append(cb.getText()+"선택해제\n");
//		}
//		
//	}
//


class EventI implements ItemListener{
	public void itemStateChanged(ItemEvent arg0) {
		JCheckBox cb = (JCheckBox) arg0.getSource();
		if(cb.isSelected()) {
			ta.append(cb.getText()+"선택\n");
		}else {
			ta.append(cb.getText()+"선택해제\n");
		}
		
	}
}
}