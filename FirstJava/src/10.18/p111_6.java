package day01;
import java.util.Scanner;
public class p111_6 {
public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		System.out.println("1~99 ������ ������ �Է��Ͻÿ�>>");
		int n = sc.nextInt();


		int n1=n/10; //�ʴ���
		int n2=n%10; //�ϴ���
		
		
		if(n1==3||n1==6||n1==9) {
			System.out.println("�ڼ�¦¦"); //�ΰ� ���ö�
		}else if(n2==3||n2==6||n2==9) {
			System.out.println("�ڼ�¦"); //�Ѱ� ���ö�
		}else {
			System.out.println("3, 6, 9 �����ϴ�.");
		}
}
}