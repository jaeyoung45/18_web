package chap05;

public class Child extends Father{
	public Child() {
		System.out.println("Child ������");
	}
	public void childMethod() {
		System.out.println("ChildMethod");
	}
	//�������̵�
	public void fatherMethod() {
		System.out.println("child�� �������̵� ->fatherMethod");
	}
}
