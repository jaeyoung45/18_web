package day01;

public class Exam02 {
public static void main(String[] args) {
	int a =10;
	float f ;
	
	f= 10; //����ȯ(ĳ����) //  �ڵ�����ȯ
	float f1 = 10.5f;
	a = (int)f1; //int = float ����ȯ(ĳ����) <-  ���������ȯ
	System.out.println(a);
	System.out.println(f);
	
	//�� ���� : ������*������*3.14
	final double PI = 3.14; //������(final <- ��� : ���ϸ� �ȵ�)
	double r = 10.5;
	double area  = r*r*PI;
	//pi = 4.5;
	System.out.println("�� ���� :" +area);
}
}
