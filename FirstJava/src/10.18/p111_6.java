package day01;
import java.util.Scanner;
public class p111_6 {
public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		System.out.println("1~99 사이의 정수를 입력하시오>>");
		int n = sc.nextInt();


		int n1=n/10; //십단위
		int n2=n%10; //일단위
		
		
		if(n1==3||n1==6||n1==9) {
			System.out.println("박수짝짝"); //두개 나올때
		}else if(n2==3||n2==6||n2==9) {
			System.out.println("박수짝"); //한개 나올때
		}else {
			System.out.println("3, 6, 9 없습니다.");
		}
}
}