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

public class CheckBoxTest1 extends JFrame{
	JTextArea ta;
	public CheckBoxTest1() {
		setTitle("checkboxTest");
		setLayout(new BorderLayout());
		JCheckBox cb1 = new JCheckBox("�ٳ���");
		JCheckBox cb2 = new JCheckBox("������");
		ta = new JTextArea(10,20);
		JPanel p = new JPanel();
		p.add(cb1);
		p.add(cb2);
		cb1.addItemListener((new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(cb1.isSelected()) {
					ta.append(cb1.getText()+"����\n");
				}else if(cb1.isSelected()){
					ta.append(cb1.getText()+"��������\n");
				}
				}
			}));
		cb2.addItemListener((new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(cb2.isSelected()) {
					ta.append(cb2.getText()+"����\n");
				}else if(cb2.isSelected()) {
					ta.append(cb2.getText()+"��������\n");
				}
				}
		}));
		JScrollPane jsp = new JScrollPane(ta);
		add(BorderLayout.NORTH,p);
		add(BorderLayout.CENTER,jsp);
		
		
		setSize(400,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CheckBoxTest1();

	}
}

//	public void itemStateChanged(ItemEvent arg0) {
//		JCheckBox cb = (JCheckBox) arg0.getSource();
//		if(cb.isSelected()) {
//			ta.append(cb.getText()+"����\n");
//		}else {
//			ta.append(cb.getText()+"��������\n");
//		}
//		
//	}
//


