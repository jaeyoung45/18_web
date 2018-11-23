package chap04;

public class PersonMain {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name= "홍길동";
		p1.addr= "부산";
		p1.study();
	
		Person p2 = new Person();
		p2.name= "강감찬";
		p2.addr= "서울";
		p2.run();
	
		Baby b2 = new Baby();
		//b2.study;
		b2.cry();
		System.out.println(p1.name);
		System.out.println(p2.name);
		System.out.println(p1);
	}
}
