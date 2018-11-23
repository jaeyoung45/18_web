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
		setTitle("List ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout()); //��������
		tf = new JTextField(15);
		JButton btn = new JButton("�߰�");
		cb = new JCheckBox("���߼���");
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
		//tf�� ���� ������ ����Ʈ�� �߰�
		//if(tf.getText().length()==0) return;
		if(tf.getText().isEmpty())return;
		lst.add(tf.getText());
		tf.setText("");
	}
		@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		if(obj==cb) {
			if(cb.isSelected()) { //üũ ����
				lst.setMultipleMode(true); //����Ʈ�� ���߸���
			}else { //üũ ����
				lst.setMultipleMode(false); //����Ʈ�� ���ϸ���
			}
		}else { //����Ʈ �̺�Ʈ
			ta.setText("");
			if(lst.isMultipleMode()) { // ����Ʈ ���߸��
				String[] tmp = lst.getSelectedItems();
				for(int i=0; i<tmp.length; i++) {
					ta.append(tmp[i]+"\n");
				}
				
			}else { // ����Ʈ ���ϸ��
			ta.setText(lst.getSelectedItem());
			}
			
		}
	}
	}
}
