package day01;
import java.util.Scanner;

public class Baesu {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("���ڸ� �Է��Ͻÿ�.");
	int Baesu = sc.nextInt();
	sc.close();
	
	if(Baesu%3==0) {
		System.out.println("3�� ���");
	}else {
		System.out.println("�ƴմϴ�");
	}
}
}
