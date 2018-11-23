package chap07;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
	ArrayList alist = new ArrayList();
	alist.add("one");
	alist.add("1");
	alist.add("two");
	alist.add(2);//래퍼클래스
	alist.add(new Integer(3));
	System.out.println(alist.size());
	System.out.println("two :"+alist.get(2));
	System.out.println("마지막 :"+alist.get(alist.size()-1));
	for(int i=0; i<alist.size(); i++) {
		System.out.println(alist.get(i));
	}
	for(Object obj : alist) {
		System.out.println(obj);
	}
	alist.add(2, "딸기");
	System.out.println("alist 길이 :"+alist.size());
	for(Object obj : alist) {
		System.out.println(obj);
	}
	alist.remove(0);
	System.out.println("제거 후 :");
	for(Object obj : alist) {
		System.out.println(obj);
	}
	System.out.println("딸기 제거 후 :");
	alist.remove("딸기");
	for(Object obj : alist) {
		System.out.println(obj);
	}
	String[] arr = new String[5];
	arr[0] = "바나나";

	//제네릭
	ArrayList<String> blist = new ArrayList<>();
	blist.add("딸기");
	//blist.add(1);
	blist.add("바나나");
	for(String s : blist) {
		System.out.println(s);
	}
	}

}
