package day01;
import java.util.Scanner;

public class Circle {
	public static void main(String[] args) {
		final double PI = 3.14;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�������� �Է��ϼ���");
		int r = sc.nextInt(); //������ �Է�
		double area = r*r*PI;
		System.out.println("�� ���� :"+area);
	}
}
