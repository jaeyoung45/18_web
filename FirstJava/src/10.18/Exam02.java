package chap03;
import java.util.Scanner;
public class Exam02 {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
			System.out.println("입력할 수의 값");
			int su=sc.nextInt();
			System.out.println("데이터 입력");
			int hap=0;
			for(int i=0; i<su; i++) {
				int inputData = sc.nextInt();
				hap += inputData;
			}
			System.out.println("입력합계 :"+hap);
	}
}	
			