package chap03;
import java.util.Scanner;
public class While02 {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("수를 입력하세요(5개)");
		int sum = 0;
		for(int i=0;i<5;i++) {
			int a = sc.nextInt();
			/*if(a%2==0) {
				sum +=a;
			}
		}*/
			if(a%2 !=0) continue;
			sum += a;
		System.out.println("합계 :"+sum);
		}
	}
}	
