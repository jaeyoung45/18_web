package chap05;

public class GrandFather {
	protected String value ="�������";
	public GrandFather() {
		System.out.println("GrandFather ������");
	}
	public GrandFather(String str) {
		System.out.println("GrandFather ������ "+str);
	}
	public void grandfatherMethod() {
		System.out.println("grandfatherMethod");
	}
}
