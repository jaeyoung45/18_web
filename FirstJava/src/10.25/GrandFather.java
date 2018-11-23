package chap05;

public class GrandFather {
	protected String value ="재산있음";
	public GrandFather() {
		System.out.println("GrandFather 생성자");
	}
	public GrandFather(String str) {
		System.out.println("GrandFather 생성자 "+str);
	}
	public void grandfatherMethod() {
		System.out.println("grandfatherMethod");
	}
}
