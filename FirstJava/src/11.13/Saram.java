package chap13_thread;

public class Saram {
	private String name;
	public Saram(String name) {
		this.name = name;
	}
	public void speak() {
		for(int i=0; i<5; i++) {
		System.out.println(name+"���Ѵ�.");
		}
	}

	public static void main(String[] args) {
		Saram s1 = new Saram("ȫ�浿");
		Saram s2 = new Saram("�̼���");
		Saram s3 = new Saram("������");
		s1.speak();
		s2.speak();
		s3.speak();

	}

}
