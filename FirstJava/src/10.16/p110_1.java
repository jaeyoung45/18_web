package day01;
import java.util.Scanner;
public class p110_1 {
public static void main(String[] args) {
	
	Scanner sc= new Scanner(System.in);
	System.out.println("원화를 입력하세요(단위 원)>>");
	int won = sc.nextInt();
	sc.close();
	
	float gap = won/1100;
	System.out.println(won+"원은"+"$" +gap+"입니다." );
	}
}
