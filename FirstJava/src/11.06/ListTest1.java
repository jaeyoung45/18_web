package chap09;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ListTest1 extends JFrame {
	private JTextField tf;
	private JTextArea  ta;
	private List lst;
	private JCheckBox cb;
	public ListTest1() {
		setTitle("List 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout()); //생략가능
		tf = new JTextField(15);
		JButton btn = new JButton("추가");
		cb = new JCheckBox("다중선택");
		p1.add(tf);
		p1.add(btn);
		p1.add(cb);
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1,2));
		lst = new List();
		ta = new JTextArea();
		p2.add(lst);
		p2.add(ta);
		btn.addActionListener(new FlowEvent());
		lst.addItemListener(new FlowEvent());
		cb.addItemListener(new FlowEvent());
		add(BorderLayout.NORTH,p1);
		add(BorderLayout.CENTER,p2);
		
		
		setSize(400, 400);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new ListTest1();

	}
	
	
	class FlowEvent implements ActionListener, ItemListener{
		@Override
	public void actionPerformed(ActionEvent e) {
		//tf에 적은 내용을 리스트에 추가
		//if(tf.getText().length()==0) return;
		if(tf.getText().isEmpty())return;
		lst.add(tf.getText());
		tf.setText("");
	}
		@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		if(obj==cb) {
			if(cb.isSelected()) { //체크 선택
				lst.setMultipleMode(true); //리스트를 다중모드로
			}else { //체크 해제
				lst.setMultipleMode(false); //리스트를 단일모드로
			}
		}else { //리스트 이벤트
			ta.setText("");
			if(lst.isMultipleMode()) { // 리스트 다중모드
				String[] tmp = lst.getSelectedItems();
				for(int i=0; i<tmp.length; i++) {
					ta.append(tmp[i]+"\n");
				}
				
			}else { // 리스트 단일모드
			ta.setText(lst.getSelectedItem());
			}
			
		}
	}
	}
}
