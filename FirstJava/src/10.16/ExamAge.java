package day01;
import java.util.Scanner;

public class ExamAge {
public static void main(String[] args) {
	
	
	Scanner sc = new Scanner(System.in);
	System.out.println("이름을 입력하시오");
	String name = sc.next();
	
	System.out.println("나이를 입력하시오");
	int age = sc.nextInt();
	sc.close();
	
	System.out.println("이름 :"+name);
	System.out.println("나이 :"+age);
}
}
