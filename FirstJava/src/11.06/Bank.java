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
		JPanel p1 = new JPanel(); //이름 있는 라인
		p1.add(new JLabel("이름"));
		tfName = new JTextField(15);
		p1.add(tfName);
		JButton btn = new JButton("계좌생성");
		
		JPanel p2 = new JPanel(); //잔액 있는 라인
		p2.add(new JLabel("잔액"));
		tfBalance = new JTextField(15);
		tfBalance.setEditable(false); //수정불가
		p2.add(tfBalance);
		
		JPanel p3 = new JPanel(); //원 있는 라인
		tfMoney = new JTextField(15);
		p3.add(tfMoney);
		p3.add(new JLabel("원"));
		
		JPanel p4 = new JPanel();
		JButton inputBtn = new JButton("예금");
		JButton outputBtn = new JButton("출금");
		JButton fileBtn = new JButton("파일로 저장");
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
		//계좌생성
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//공백넣으면 그만
				if(tfName.getText().isEmpty()) return;//tfName 값을 가져와서 lst에 추가
				lst.add(tfName.getText().trim());
				//hm에 추가
				hm.put(tfName.getText().trim(),0);
				tfName.setText("");
			}
		});
		//예금버튼
		inputBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * 1.리스트에 선택된 계좌 잔액에
				 * 2.얼마를 더해서
				 * 3.잔액 고쳐주고 맵에 추가
				 */
				try {
					String key = lst.getSelectedItem().trim();
					int balance = hm.get(key); //잔액
					int value = balance+Integer.parseInt(tfMoney.getText());
					hm.put(key, value);	//맵에 잔액 수정
					tfBalance.setText(value+"");//예금 처리된 잔액표시
					tfMoney.setText(""); //편의를 위해 예금된 돈 지우기
				}catch(NullPointerException ar){
				 new MessageBox("오류!!!" , "계좌를 선택하세요");
				}catch(NumberFormatException e2) {
					new MessageBox("입력오류!!!", "숫자를 입력하세요");
				}
			
			}
			
		});
		//출금버튼
		outputBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * 1.리스트에 선택된 계좌 잔액에
				 * 2.얼마를 빼서
				 * 3.잔액 고쳐주고 맵에 추가
				 */
				try {
				String key = lst.getSelectedItem().trim();
				int balance = hm.get(key); //잔액
				int value = balance-Integer.parseInt(tfMoney.getText());
				if(value<0) {
					//System.out.println("잔액부족");
					new MessageBox("잔액부족!!!",key+"님 잔액이 부족합니다.");
					return;
				}
				hm.put(key, value);	//맵에 잔액 수정
				tfBalance.setText(value+"");//예금 처리된 잔액표시
				tfMoney.setText(""); //편의를 위해 예금된 돈 지우기
				}catch (NumberFormatException n) {
					new MessageBox("입력오류!!!", "숫자를 입력하세요.");
				}catch (NullPointerException e2) {
					new MessageBox("오류!!", "계좌를 선택하세요");
				}
				
			}
		});
		//List 클릭시 발생하는 이벤트
		lst.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				//리스트에서 선택된 이름을 tfName에 넣기
				String name = lst.getSelectedItem().trim();
				tfName.setText(name);
				//리스트에서 선택된 이름의 잔액을 tfBalance 에  넣기
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
				String key = it.next();//이름
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
		load(); //파일을 읽어서 해쉬맵에 넣는 함수
	}
	private void load() {
		hm.clear();
		File dir = new File("src\\chap09");
		File file = new File(dir, "mybank.txt");
		try {
	if(file.exists()) file.createNewFile(); //파일 없으면 새로 만들기
		Scanner sc = new Scanner(file);	
		while(sc.hasNext()) {
			String name = sc.next().trim(); //이름
			int money = sc.nextInt(); //잔액
			hm.put(name, money); //맵에 추가
			lst.add(name+"\n");
		}
		sc.close();
		
		} catch (IOException e) {
			new MessageBox("파일저장오류!!", "파일저장 오류발생");
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		new Bank();

	}

		
	}

