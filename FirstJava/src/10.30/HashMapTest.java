package chap07;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String,String> hm = new HashMap<>();
		hm.put("one", "ù��°");
		hm.put("two", "�ι�°");
		hm.put("three","����°");
		hm.put("four", "�׹�°");
		hm.put("one", "ù��° ��");
		
		System.out.println(hm);
		System.out.println("ũ�� :"+hm.size());
		
		for(int i=0; i<hm.size(); i++) {
			System.out.println(hm.get("one"));
			
		}
		
		HashMap<String,String> h = new HashMap<>();
		h.put("1", "ù��°");
		h.put("2", "�ι�°");
		h.put("3", "����°");
		h.put("4", "�׹�°");
		
		System.out.println(h);
		System.out.println("ũ�� :"+h.size());
		
		for(int k=0; k<h.size(); k++) {
			//System.out.println(h.get(String.valueOf(k+1))+" ");
			System.out.print(h.get(k+1+"")+" ");
		}
		System.out.println();
		System.out.println(h.containsKey("1"));
		System.out.println(h.containsValue("����°"));
		System.out.println("----value ������ ���ϱ�----");
		for(String str : h.values()) {
			System.out.println(str);
		}
		System.out.println("----key ������ ���ϱ�----");
		for(String k :h.keySet()) {
			System.out.println(h.get(k));
		}
	}

}

