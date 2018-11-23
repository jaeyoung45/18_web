package chap07;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String,String> hm = new HashMap<>();
		hm.put("one", "첫번째");
		hm.put("two", "두번째");
		hm.put("three","세번째");
		hm.put("four", "네번째");
		hm.put("one", "첫번째 값");
		
		System.out.println(hm);
		System.out.println("크기 :"+hm.size());
		
		for(int i=0; i<hm.size(); i++) {
			System.out.println(hm.get("one"));
			
		}
		
		HashMap<String,String> h = new HashMap<>();
		h.put("1", "첫번째");
		h.put("2", "두번째");
		h.put("3", "세번째");
		h.put("4", "네번째");
		
		System.out.println(h);
		System.out.println("크기 :"+h.size());
		
		for(int k=0; k<h.size(); k++) {
			//System.out.println(h.get(String.valueOf(k+1))+" ");
			System.out.print(h.get(k+1+"")+" ");
		}
		System.out.println();
		System.out.println(h.containsKey("1"));
		System.out.println(h.containsValue("세번째"));
		System.out.println("----value 값으로 구하기----");
		for(String str : h.values()) {
			System.out.println(str);
		}
		System.out.println("----key 값으로 구하기----");
		for(String k :h.keySet()) {
			System.out.println(h.get(k));
		}
	}

}

