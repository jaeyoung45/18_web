package day01;
import java.util.Scanner;

public class ExamSu2 {
public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	System.out.println("첫번째 수 입력");
	int a = sc.nextInt();
	System.out.println("두번째 수 입력");
	int b = sc.nextInt();
	System.out.println("연산자 입력");
	String tmp = sc.next();
	sc.close();
	
	switch(tmp) {
	case "+":
	System.out.println(a+b);
	case "-":
	System.out.println(a-b);
	case "*":
	System.out.println(a*b);
	case "/":
	System.out.println(a/b);
	case "%":
	System.out.println(a%b);
	}
}
}

	

