package chap07;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
	ArrayList alist = new ArrayList();
	alist.add("one");
	alist.add("1");
	alist.add("two");
	alist.add(2);//����Ŭ����
	alist.add(new Integer(3));
	System.out.println(alist.size());
	System.out.println("two :"+alist.get(2));
	System.out.println("������ :"+alist.get(alist.size()-1));
	for(int i=0; i<alist.size(); i++) {
		System.out.println(alist.get(i));
	}
	for(Object obj : alist) {
		System.out.println(obj);
	}
	alist.add(2, "����");
	System.out.println("alist ���� :"+alist.size());
	for(Object obj : alist) {
		System.out.println(obj);
	}
	alist.remove(0);
	System.out.println("���� �� :");
	for(Object obj : alist) {
		System.out.println(obj);
	}
	System.out.println("���� ���� �� :");
	alist.remove("����");
	for(Object obj : alist) {
		System.out.println(obj);
	}
	String[] arr = new String[5];
	arr[0] = "�ٳ���";

	//���׸�
	ArrayList<String> blist = new ArrayList<>();
	blist.add("����");
	//blist.add(1);
	blist.add("�ٳ���");
	for(String s : blist) {
		System.out.println(s);
	}
	}

}
