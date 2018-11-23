package chap05;

public class Father extends GrandFather{
	public Father() {
		super("할머니"); //부모 생산자를 부름(생략가능)
		System.out.println("Father 생성자");
	}
	public void fatherMethod() {
		System.out.println("fatherMethod");
	}
//오버라이딩 (부모의 메소드를 자식이 재정의 하는 것)	
	public void grandFatherMethod() {
		 System.out.println("grandFatherMethod<-아버지가 수정할 예정");
 }
}

