package chap04;

public class Baby {
	String name;
	int age;
	
	//���´�
	public void smile() {
		System.out.println("���´�");
	}
	//���.
	public void cry() {
		System.out.println("���");
	}
	
	
	public static void main(String[] args) {
		Baby b1 = new Baby();
		b1.smile();
		b1.name="ȫ�浿";
		System.out.println(b1.name);

	}

}
