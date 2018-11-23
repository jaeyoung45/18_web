package day01;
import java.util.Scanner;

public class Circle {
	public static void main(String[] args) {
		final double PI = 3.14;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("반지름을 입력하세요");
		int r = sc.nextInt(); //정수값 입력
		double area = r*r*PI;
		System.out.println("원 넓이 :"+area);
	}
}
