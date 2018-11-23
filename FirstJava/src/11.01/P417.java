package chap07;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class P417 {

	public static void main(String[] args) {
		// �̸��� ������ ������ HashMap �÷��� ����
		HashMap<String, Integer> scoreMap = new HashMap<>();
			//var scoreMap = new HashMap<String, Integer>();�� ������ �ᵵ ��
		
		// 5���� ���� ����
		scoreMap.put("�輺��", 97);
		scoreMap.put("Ȳ����", 88);
		scoreMap.put("�賲��", 98);
		scoreMap.put("���繮", 70);
		scoreMap.put("�ѿ���", 99);
		
		System.out.println("HashMap�� ��� ���� :" + scoreMap.size());
		
		// ��� ����� ���� ���. scoreMap�� ��� �ִ� ��� (key, value) �� ���
		Set<String> keys = scoreMap.keySet();
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()) {
			String name = it.next();
			int score = scoreMap.get(name);
			System.out.println(name + " : "+score);
		}
	}
}
