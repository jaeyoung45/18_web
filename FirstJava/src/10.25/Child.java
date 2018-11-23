package chap05;

public class Child extends Father{
	public Child() {
		System.out.println("Child 생성자");
	}
	public void childMethod() {
		System.out.println("ChildMethod");
	}
	//오버라이딩
	public void fatherMethod() {
		System.out.println("child가 오버라이딩 ->fatherMethod");
	}
}
