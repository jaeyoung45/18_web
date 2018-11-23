package chap05;

public class Main {

	public static void main(String[] args) {
		/*Child c = new Child();
		Father f = new Father();
		c.fatherMethod();
		//f.childMethod();
		c.grandfatherMethod();
		System.out.println(c.value);
		f.grandfatherMethod();*/
		Father f1;
		Child c1 = new Child();
		f1=c1; //f1은 Father객체. Child에 있는 오버라이딩 메소드 접근가능
		//f1.childMethod();
		f1.fatherMethod();
		
		Father f2 = new Child();
	}
}
