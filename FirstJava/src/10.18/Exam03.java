package chap03;
import java.util.Scanner;
public class Exam03 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int sum1 = 0;
		for(int i=1;i<=100;i++) {
			sum1 += i;
			if(i%10==0) {
				System.out.println("1����"+i+"������ �� :" +sum1);
			}
		}	
			//���� for�� �̿�
		int sum2=0;
		for(int i=1;i<=100;i+=10) {
			int j;
			for(j=i;j<i+10;j++) {
				sum2 +=j;
			}
			System.out.println("1����" +(j-1)+"������ �� :" +sum2);
		}
		
	}
	
}
