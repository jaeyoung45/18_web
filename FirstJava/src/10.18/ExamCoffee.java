package day01;
import java.util.Scanner;
public class ExamCoffee {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	System.out.println("���� Ŀ�Ǹ� �帱���?");
	
	String menu = sc.next();
	int price=0;
	switch (menu) {
	case "�����䷹��":
	case "īǪġ��":
	case "ī���":	price =3500; break;
	case "�Ƹ޸�ī��":	price =2000; break;
	}	
		System.out.println("�޴��� �����ϴ�!");
		System.out.println(menu+":"+price);
	
		System.out.println("ü�� �Է�");
		double weight = sc.nextDouble();
		System.out.println("��Ʈ�� ���� :������ true/������ false");
		boolean flag = sc.nextBoolean();
		if(flag) {
			System.out.println("��Ʈ�� ����");	
		}else {
			System.out.println("��Ʈ�� ����");
		}
		System.out.println("ü�� :" +weight);	
		sc.close();	
		}
}
