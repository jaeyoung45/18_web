package day01;
import java.util.Scanner;

public class ExamSu2 {
public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	System.out.println("ù��° �� �Է�");
	int a = sc.nextInt();
	System.out.println("�ι�° �� �Է�");
	int b = sc.nextInt();
	System.out.println("������ �Է�");
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

	

