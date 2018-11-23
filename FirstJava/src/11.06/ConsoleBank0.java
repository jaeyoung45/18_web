package chap09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ConsoleBank {

	public static void main(String[] args) {
		String name;
		int money;
		HashMap<String,Integer> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("1.���»��� 2.��/��� 3.Ȯ��/��������");
		int num =sc.nextInt();
		if(num==1) {
			System.out.println("�̸����Է��ϼ���>>");
			name = sc.next();
			money = 0;
			map.put(name, 0);
			
		}else if(num==2) {
			System.out.println("1. �Ա� 2.���");
			int su = sc.nextInt();
			if(su==1) {
				System.out.println("�̸���?");
				name = sc.next();
				if(map.containsKey(name)) {
				System.out.println("�Աݱݾ�>>");
				int don=sc.nextInt();
				map.put(name,map.get(name)+don);
				}else {System.out.println("���� �����Դϴ�.");}
			}else if(su==2) {
				System.out.println("�̸���?");
				name = sc.next();
				if(map.containsKey(name)) {
				System.out.println("��ݱݾ�>>");
				int don=sc.nextInt();
				map.put(name,map.get(name)-don);
				}else {System.out.println("���� �����Դϴ�.");}
			}else {System.out.println("�ٽ��Է��ϼ���"); return;}
		}else if(num==3) {
			File dir = new File("src\\chap09");
			File file = new File(dir,"myBank.txt");
			System.out.println(map);
			try {
				FileWriter tw = new FileWriter(file);
				Set<String> keys = map.keySet(); // ��� Ű�� ���� �� �÷��� ����
				Iterator<String> it = keys. iterator();
				while(it.hasNext()) {
					name = it.next().trim();
					money = map.get(name);
					tw.write(name+":"+money+"\n");
					}
				tw.close();
				}catch(FileNotFoundException f) {
					new MessageBox("�����������!","���Ͼ���");
					f.printStackTrace(); 
			    } catch (IOException e1) {
					e1.printStackTrace();
			    }
			}
		}
	}
}
