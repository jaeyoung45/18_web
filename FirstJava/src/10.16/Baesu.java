package day01;
import java.util.Scanner;

public class Baesu {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("숫자를 입력하시오.");
	int Baesu = sc.nextInt();
	sc.close();
	
	if(Baesu%3==0) {
		System.out.println("3의 배수");
	}else {
		System.out.println("아닙니다");
	}
}
}
