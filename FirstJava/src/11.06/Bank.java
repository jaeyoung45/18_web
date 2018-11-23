package chap09;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bank extends JFrame {
	private JTextField tfName, tfBalance, tfMoney;
	HashMap<String,Integer>hm = new HashMap<>();
	List lst;
	public Bank() {
		setTitle("Bank");
		setLayout(new GridLayout(1,2));
		JPanel p1 = new JPanel(); //�̸� �ִ� ����
		p1.add(new JLabel("�̸�"));
		tfName = new JTextField(15);
		p1.add(tfName);
		JButton btn = new JButton("���»���");
		
		JPanel p2 = new JPanel(); //�ܾ� �ִ� ����
		p2.add(new JLabel("�ܾ�"));
		tfBalance = new JTextField(15);
		tfBalance.setEditable(false); //�����Ұ�
		p2.add(tfBalance);
		
		JPanel p3 = new JPanel(); //�� �ִ� ����
		tfMoney = new JTextField(15);
		p3.add(tfMoney);
		p3.add(new JLabel("��"));
		
		JPanel p4 = new JPanel();
		JButton inputBtn = new JButton("����");
		JButton outputBtn = new JButton("���");
		JButton fileBtn = new JButton("���Ϸ� ����");
		p4.add(inputBtn);
		p4.add(outputBtn);
		p4.add(fileBtn);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,1));
		panel.add(p1);
		panel.add(btn);
		panel.add(p2);
		panel.add(p3);
		panel.add(p4);
		
		lst = new List();
		add(panel);
		add(lst);
		//���»���
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//��������� �׸�
				if(tfName.getText().isEmpty()) return;//tfName ���� �����ͼ� lst�� �߰�
				lst.add(tfName.getText().trim());
				//hm�� �߰�
				hm.put(tfName.getText().trim(),0);
				tfName.setText("");
			}
		});
		//���ݹ�ư
		inputBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * 1.����Ʈ�� ���õ� ���� �ܾ׿�
				 * 2.�󸶸� ���ؼ�
				 * 3.�ܾ� �����ְ� �ʿ� �߰�
				 */
				try {
					String key = lst.getSelectedItem().trim();
					int balance = hm.get(key); //�ܾ�
					int value = balance+Integer.parseInt(tfMoney.getText());
					hm.put(key, value);	//�ʿ� �ܾ� ����
					tfBalance.setText(value+"");//���� ó���� �ܾ�ǥ��
					tfMoney.setText(""); //���Ǹ� ���� ���ݵ� �� �����
				}catch(NullPointerException ar){
				 new MessageBox("����!!!" , "���¸� �����ϼ���");
				}catch(NumberFormatException e2) {
					new MessageBox("�Է¿���!!!", "���ڸ� �Է��ϼ���");
				}
			
			}
			
		});
		//��ݹ�ư
		outputBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * 1.����Ʈ�� ���õ� ���� �ܾ׿�
				 * 2.�󸶸� ����
				 * 3.�ܾ� �����ְ� �ʿ� �߰�
				 */
				try {
				String key = lst.getSelectedItem().trim();
				int balance = hm.get(key); //�ܾ�
				int value = balance-Integer.parseInt(tfMoney.getText());
				if(value<0) {
					//System.out.println("�ܾ׺���");
					new MessageBox("�ܾ׺���!!!",key+"�� �ܾ��� �����մϴ�.");
					return;
				}
				hm.put(key, value);	//�ʿ� �ܾ� ����
				tfBalance.setText(value+"");//���� ó���� �ܾ�ǥ��
				tfMoney.setText(""); //���Ǹ� ���� ���ݵ� �� �����
				}catch (NumberFormatException n) {
					new MessageBox("�Է¿���!!!", "���ڸ� �Է��ϼ���.");
				}catch (NullPointerException e2) {
					new MessageBox("����!!", "���¸� �����ϼ���");
				}
				
			}
		});
		//List Ŭ���� �߻��ϴ� �̺�Ʈ
		lst.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				//����Ʈ���� ���õ� �̸��� tfName�� �ֱ�
				String name = lst.getSelectedItem().trim();
				tfName.setText(name);
				//����Ʈ���� ���õ� �̸��� �ܾ��� tfBalance ��  �ֱ�
				tfBalance.setText(hm.get(name)+"");
				//tfBalance.setText(String.valueOf(hm.get(name)));
			}
		
		});
		
		//fileBtn ->mybank.txt
		fileBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			File dir = new File("src\\chap09");
			File file = new File(dir, "mybank.txt");
			try {
			FileWriter fw = new FileWriter(file);
			Set<String> set = hm.keySet();
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				String key = it.next();//�̸�
				fw.write(key + " ");
				fw.write(hm.get(key)+"\n");
			}
			fw.close();
			
			}catch (IOException e1) {
				
			}
			
			}
			
		});
		setSize(600, 300);
		setVisible(true);
		load(); //������ �о �ؽ��ʿ� �ִ� �Լ�
	}
	private void load() {
		hm.clear();
		File dir = new File("src\\chap09");
		File file = new File(dir, "mybank.txt");
		try {
	if(file.exists()) file.createNewFile(); //���� ������ ���� �����
		Scanner sc = new Scanner(file);	
		while(sc.hasNext()) {
			String name = sc.next().trim(); //�̸�
			int money = sc.nextInt(); //�ܾ�
			hm.put(name, money); //�ʿ� �߰�
			lst.add(name+"\n");
		}
		sc.close();
		
		} catch (IOException e) {
			new MessageBox("�����������!!", "�������� �����߻�");
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		new Bank();

	}

		
	}

