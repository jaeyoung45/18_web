package day01;
import java.util.Scanner;
public class p110_2 {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("2�ڸ��� ���� �Է�(10~99)>>");
		int n = sc.nextInt();
		
		if(n>=10 && n<=99) {
			if(n/10 == n%10) {
		System.out.println("Yes! 10�� �ڸ��� 1�� �ڸ��� �����ϴ�.");
		}else{
		System.out.println("No! 10�� �ڸ��� 1�� �ڸ��� �����ʽ��ϴ�.");
	}
}
}
}