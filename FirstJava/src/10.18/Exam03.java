package chap03;
import java.util.Scanner;
public class Exam03 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int sum1 = 0;
		for(int i=1;i<=100;i++) {
			sum1 += i;
			if(i%10==0) {
				System.out.println("1부터"+i+"까지의 합 :" +sum1);
			}
		}	
			//이중 for문 이용
		int sum2=0;
		for(int i=1;i<=100;i+=10) {
			int j;
			for(j=i;j<i+10;j++) {
				sum2 +=j;
			}
			System.out.println("1부터" +(j-1)+"까지의 합 :" +sum2);
		}
		
	}
	
}
