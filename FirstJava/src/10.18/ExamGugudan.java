package chap03;
import java.util.Scanner;
public class ExamGugudan {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("���� �Է��ϼ���.");
		int dan = sc.nextInt();
		
		for(int i=1;i<10;i++) {
			System.out.print(dan+"*"+i+"="+dan*i+"\t");
		}
	}
}
