package chap07;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest03 {
	public static void main(String[] args) {
		HashMap <String,String> hm = new HashMap<String,String>();
		Scanner sc = new Scanner(System.in);
		hm.put("java", "1111");
		hm.put("oracle", "1234");
		hm.put("jsp", "abcd");
		System.out.println("id/password�� �Է��ϼ���");
		System.out.println("id :");
		String id = sc.next();
		
		//�Է��Ͻ� id�� �����ϴ�.
		if(hm.containsKey(id)==false) {
			System.out.println("�Է��Ͻ� id�� �����ϴ�.");
			return;
		}
		System.out.println("password :");
		String pwd = sc.next();
		if(!hm.get(id).equals(pwd)){ //��й�ȣ�� ��ġ���� �ʽ��ϴ�.
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}else { //id/password�� ��ġ�մϴ�.
			System.out.println("��� ��ġ");
		}	
	}
}
