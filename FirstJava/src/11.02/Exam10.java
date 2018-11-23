package chap08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Exam10 {
	HashMap<String,String> map = new HashMap<>();
	
	private void read() {
		//���Ϸ� ���� �о map�� ����
		try {
			Scanner sc = new Scanner(new File("phone.txt"));
			while(sc.hasNext()) {
				String name = sc.next(); //�̸�
				String phone = sc.next(); //��ȭ��ȣ
				map.put(name, phone); //�ʿ� ����
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(map.size()+"�� ��ȭ��ȣ �Է�");
	}
	private void search() {
		//map ���� �Է��� ������ �ִ��� �˻�
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("ã�� �̸� >> �����Ϸ��� X");
			String name = scanner.next();
			if(name.toUpperCase().equals("X"))
				break;
			if(map.containsKey(name)) {
				System.out.println(map.get(name));
			}else {
				System.out.println("ã�� �̸� ����");
			}
		}
		scanner.close();
	}
	
	
	public static void main(String[] args) {
		Exam10 exam = new Exam10();
		exam.read();
		exam.search();
		
	}
}
