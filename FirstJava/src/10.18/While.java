package chap03;
import java.util.Scanner;
public class While {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("������ �Է��ϰ� �������� -1�� �Է��ϼ���.");
		int sum = 0;
		int cnt = 0;
		while(true) {
			int a = sc.nextInt();
			
			if(a==-1) {
				System.out.println("�հ� :"+sum);
				System.out.println(cnt);
				System.out.println("��� :"+(sum/cnt));
				break;
			}
			sum += a;
			cnt++;
		}
	}
}	
