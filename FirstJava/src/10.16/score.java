package day01;
import java.util.Scanner;

public class score {
public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	System.out.println("���� ������ �Է��ϼ���.");
	int kor = sc.nextInt();
	
	System.out.println("���� ������ �Է��ϼ���.");
	int eng = sc.nextInt();
	
	System.out.println("���� ������ �Է��ϼ���.");
	int mat = sc.nextInt();
	sc.close();
	
	int sum = kor+eng+mat;
	int avg = sum/3;
	System.out.println("���� :"+sum+"\t��� :"+avg);
	}
}
