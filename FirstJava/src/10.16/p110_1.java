package day01;
import java.util.Scanner;
public class p110_1 {
public static void main(String[] args) {
	
	Scanner sc= new Scanner(System.in);
	System.out.println("��ȭ�� �Է��ϼ���(���� ��)>>");
	int won = sc.nextInt();
	sc.close();
	
	float gap = won/1100;
	System.out.println(won+"����"+"$" +gap+"�Դϴ�." );
	}
}
