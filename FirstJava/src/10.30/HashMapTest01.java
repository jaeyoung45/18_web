package chap07;

import java.util.HashMap;

public class HashMapTest01 {

	public static void main(String[] args) {
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int i=0; i<10; i++) {
		Integer k=0;
			while(true) {
			int v= (int)(Math.random()*20)+1;
			if(hm.containsValue(v)==false) {//v�� hm�� �ֳ� ���� ����
				hm.put(i, v); //v�� hm ���� ��
			break;
		} //if
	} //while
} //for
		System.out.println(hm);
	}
}

