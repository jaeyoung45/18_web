package day01;
import java.util.Scanner;

public class ExamAge {
public static void main(String[] args) {
	
	
	Scanner sc = new Scanner(System.in);
	System.out.println("�̸��� �Է��Ͻÿ�");
	String name = sc.next();
	
	System.out.println("���̸� �Է��Ͻÿ�");
	int age = sc.nextInt();
	sc.close();
	
	System.out.println("�̸� :"+name);
	System.out.println("���� :"+age);
}
}
