package chap05;

public class Father extends GrandFather{
	public Father() {
		super("�ҸӴ�"); //�θ� �����ڸ� �θ�(��������)
		System.out.println("Father ������");
	}
	public void fatherMethod() {
		System.out.println("fatherMethod");
	}
//�������̵� (�θ��� �޼ҵ带 �ڽ��� ������ �ϴ� ��)	
	public void grandFatherMethod() {
		 System.out.println("grandFatherMethod<-�ƹ����� ������ ����");
 }
}

