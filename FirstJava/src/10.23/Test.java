package objectArray;

public class Test {
	public void method1(int a) { //�� ����
		System.out.println("method1 �� a ="+a);
		a= 20;
		System.out.println("method1 �� a ="+a);
	}
	public void method2(int a) {
		System.out.println("method2 �� a ="+a);
		a= 30;
		System.out.println("method2 �� a ="+a);
	}
	public static void main(String[] args) {
		Test t = new Test();
		int a = 10;
		t.method1(a);
		t.method2(a);
		System.out.println(a);
	}

}
