package examPac07;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class CapitalApp {
	static Scanner sc = new Scanner(System.in);
	private HashMap<String, String> map = new HashMap<>();
	CapitalApp(){
		map.put("�ѱ�", "����");
		map.put("�Ϻ�", "����");
		map.put("�߱�", "����¡");
		map.put("ȣ��", "�õ��");
		map.put("�߽���", "�߽��ڽ�Ƽ");
		map.put("����", "���");
		map.put("����", "����");
		map.put("������", "�ĸ�");
		map.put("����", "������");
	}
	public static void showMenu() {
		System.out.println("**** ���� ���߱� ������ �����մϴ�.****");
			System.out.print("�Է�:1,����:2,����:3>>");
	}
	public void input() {
		int n= map.size();
		System.out.println("���� "+map.size()+"�� ����� ���� �Է�");
		System.out.println("�����Ϸ���  X");
		n++;
		while(true) {
			System.out.println("����� ���� �Է� "+n+">>");
			String str = sc.next(); //����
			if(str.toUpperCase().equals("X"))
				break;
			if(map.containsKey(str)) { //�Է��� ���� ������
				System.out.println("�̹� �Է��� �����Դϴ�.");
				continue;
			}
			String str1 = sc.next(); //����
			map.put(str, str1);
			n++;
		}
	}
	public void test()  {
		Set<String> set = map.keySet();
		Object[] arr = set.toArray(); //set ���� �迭�� ��ȯ
		while(true) {
			int n = (int)(Math.random()*map.size()); //������ġ ���ϱ�
			String city= (String)arr[n]; //����
			String dosi= map.get(city); //����
			
			//�������
			System.out.println(city+"�� ������ ? �����Ϸ��� X");
			String dap = sc.next();
			if(dap.toUpperCase().equals("X"))
				break;
			if(dosi.equals(dap)) {
				System.out.println("����");
			}else {
				System.out.println("Ʋ�Ƚ��ϴ�.!!!!");
			}
		}
	}
	public static void main(String[] args) {
		CapitalApp ca = new CapitalApp();
		while(true) {
			CapitalApp.showMenu();
			int choice = sc.nextInt();
			switch(choice) {
			case 1:ca.input(); break;
			case 2:ca.test(); break;
			case 3:System.out.println("����");
			System.exit(0);
			default : System.out.println("�Է¿���");
			}
		}
		

	}

}
