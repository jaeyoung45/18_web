package chap07;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest02 {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("�ܾ��Է�... ����� X");
			String str = sc.next();
			if(str.toUpperCase().equals("X")) break;
			//int value;
//			if(map.get(str)==null) { //���� ������
//				value = 1;
//			}else { //���� ������
//				value = map.get(str) +1;
//			}
//			map.put(str, value);
			map.put(str, map.get(str)==null?1:map.get(str)+1); //3�� ������
			
		
		}//while
		System.out.println(map);
	}

}
