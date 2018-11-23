package chap03;
import java.util.Scanner;
public class While {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("정수를 입력하고 마지막에 -1을 입력하세요.");
		int sum = 0;
		int cnt = 0;
		while(true) {
			int a = sc.nextInt();
			
			if(a==-1) {
				System.out.println("합계 :"+sum);
				System.out.println(cnt);
				System.out.println("평균 :"+(sum/cnt));
				break;
			}
			sum += a;
			cnt++;
		}
	}
}	
