package day01;
import java.util.Scanner;
public class p110_2 {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("2자리수 정수 입력(10~99)>>");
		int n = sc.nextInt();
		
		if(n>=10 && n<=99) {
			if(n/10 == n%10) {
		System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
		}else{
		System.out.println("No! 10의 자리와 1의 자리가 같지않습니다.");
	}
}
}
}