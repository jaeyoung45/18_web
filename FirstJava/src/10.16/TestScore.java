package day01;
import java.util.Scanner;

public class TestScore {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("���� ������ �Է��ϼ���.");
	int score=sc.nextInt();
	System.out.println("�հ� ������ �Է��ϼ���.");
	int cutline = sc.nextInt();
	if(score>=cutline) {
		System.out.println("�հ�");
	}else {
		System.out.println("���հ�");
	}
	sc.close();
	
}
}
